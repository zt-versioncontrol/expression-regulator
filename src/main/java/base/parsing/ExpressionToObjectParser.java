package base.parsing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ExpressionToObjectParser {

    private final ParsingUtilitiesService parsingService;



    protected ExpressionToObjectParser(ParsingUtilitiesService parsingService) {
        this.parsingService = parsingService;
    }


    public void parse(Object target, String expression)
            throws InvocationTargetException ,InstantiationException, IllegalAccessException
    {
        List<Field> stringDerivedFields = Arrays.stream(target.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(StringDerived.class))
                .toList();

        List<Field> stringDerivedArrayFields = Arrays.stream(target.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(StringDerivedArray.class))
                .toList();

        List<Field> stringConstructedFields = Arrays.stream(target.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(StringConstructed.class))
                .toList();

        List<Field> stringConstructedArrayFields = Arrays.stream(target.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(StringConstructedArray.class))
                .toList();

        buildStringDerivedFields(stringDerivedFields, target, expression);
        buildStringDerivedArrayFields(stringDerivedArrayFields, target, expression);
        buildStringConstructedFields(stringConstructedFields, target, expression);
        buildStringConstructedArrayFields(stringConstructedArrayFields, target, expression);

    }

    private void buildStringDerivedFields(List<Field> stringDerivedFields, Object target, String expression)
            throws InvocationTargetException ,InstantiationException, IllegalAccessException
    {
        for (Field stringDerivedField : stringDerivedFields) {
            StringDerived annotation = stringDerivedField.getAnnotation(StringDerived.class);
            Class<? extends ExpressionExtractor> extractorClass = annotation.extractor();
            Class<? extends InstanceProvider> providerClass = annotation.provider();

            ExpressionExtractor extractor = parsingService.getExpressionExtractor(extractorClass);
            if (extractor == null) throw new ExtractorNotFoundException();
            InstanceProvider provider = parsingService.getInstanceProvider(providerClass);
            if (provider == null) throw new InstanceProviderNotFoundException();

            stringDerivedField.setAccessible(true);
            try {
                String fieldExpression = extractor.extractFromExpression(expression);
                Object fieldObject = provider.provide(fieldExpression);
                parse(fieldObject, fieldExpression);
                stringDerivedField.set(target, fieldObject);
            }catch (IllegalArgumentException exception){
                throw new IncompatibleInstanceProviderException();
            }catch (IllegalAccessException ignored){}
        }
    }

    private void buildStringDerivedArrayFields(List<Field> stringDerivedArrayFields, Object target, String expression)
            throws InvocationTargetException ,InstantiationException, IllegalAccessException
    {
        for (Field stringDerivedArrayField : stringDerivedArrayFields) {
            StringDerivedArray annotation = stringDerivedArrayField.getAnnotation(StringDerivedArray.class);
            Class<? extends ExpressionArrayExtractor> extractorCLass = annotation.extractor();
            Class<? extends InstanceProvider> providerClass = annotation.provider();

            if(!stringDerivedArrayField.getType().equals(ArrayList.class))  throw new FieldIsNotArrayListException();
            ExpressionArrayExtractor extractor = parsingService.getExpressionArrayExtractor(extractorCLass);
            if (extractor == null) throw new ExtractorNotFoundException();
            InstanceProvider provider = parsingService.getInstanceProvider(providerClass);
            if (provider == null) throw new InstanceProviderNotFoundException();

            List<String> extractedExpressions = extractor.extractArrayFromExpression(expression);
            ArrayList<Object> providedObjects = new ArrayList<>();
            for (String extractedExpression : extractedExpressions) {
                Object object = provider.provide(extractedExpression);
                parse(object, expression);
                providedObjects.add(object);
            }

            stringDerivedArrayField.setAccessible(true);
            try {
                stringDerivedArrayField.set(target, providedObjects);
            }catch (IllegalAccessException ignored){}

        }
    }

    private void buildStringConstructedFields(List<Field> stringConstructedFields, Object target, String expression)
            throws InvocationTargetException ,InstantiationException, IllegalAccessException
    {
        for (Field stringConstructedField : stringConstructedFields) {
            StringConstructed annotation = stringConstructedField.getAnnotation(StringConstructed.class);
            Class<? extends ExpressionExtractor> extractorCLass = annotation.extractor();

            ExpressionExtractor extractor = parsingService.getExpressionExtractor(extractorCLass);
            if (extractor == null) throw new ExtractorNotFoundException();

            stringConstructedField.setAccessible(true);
            Constructor fieldConstructor;
            try {
                fieldConstructor = stringConstructedField.getType().getConstructor(String.class);
            }catch (NoSuchMethodException exception){
                throw new FieldHasNoStringConstructorException();
            }

            String fieldExpression = extractor.extract(expression);
            Object fieldObject = fieldConstructor.newInstance(fieldExpression);
            parse(fieldObject, fieldExpression);
            stringConstructedField.set(target, fieldObject);
        }
    }


    private void buildStringConstructedArrayFields(List<Field> stringConstructedArrayFields, Object target, String expression)
            throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        for (Field stringConstructedArrayField : stringConstructedArrayFields) {
            StringConstructedArray annotation = stringConstructedArrayField.getAnnotation(StringConstructedArray.class);
            Class<? extends ExpressionArrayExtractor> extractorClass = annotation.extractor();
            Constructor arrayElementConstructor;

            if (!stringConstructedArrayField.getType().equals(ArrayList.class)) throw new FieldIsNotArrayListException();
            ExpressionArrayExtractor extractor = parsingService.getExpressionArrayExtractor(extractorClass);
            if (extractor == null) throw new ExtractorNotFoundException();

            try{
                arrayElementConstructor = annotation.of().getConstructor(String.class);
            }catch (NoSuchMethodException exception){
                throw new FieldHasNoStringConstructorException();
            }

            stringConstructedArrayField.setAccessible(true);
            List<String> extractedExpressions = extractor.extract(expression);
            ArrayList<Object> constructedObjects = new ArrayList<>();
            for (String extractedExpression : extractedExpressions) {
                Object constructedObject = arrayElementConstructor.newInstance(extractedExpression);
                parse(constructedObject, extractedExpression);
                constructedObjects.add(constructedObject);
            }
            stringConstructedArrayField.set(target, constructedObjects);
        }
    }


    public static class ExtractorNotFoundException extends RuntimeException{}
    public static class InstanceProviderNotFoundException extends RuntimeException{}
    public static class IncompatibleInstanceProviderException extends RuntimeException{}
    public static class FieldIsNotArrayListException extends RuntimeException{};
    public static class FieldHasNoStringConstructorException extends RuntimeException{};
}
