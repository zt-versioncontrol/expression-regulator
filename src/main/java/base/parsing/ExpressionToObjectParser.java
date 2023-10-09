package base.parsing;

import base.components.expression.parsing.ExpressionArrayExtractor;
import base.components.expression.parsing.ExpressionExtractor;
import base.components.expression.parsing.InstanceProvider;
import base.expressions.Expression;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ExpressionToObjectParser {

    private final ParsingUtilitiesService parsingService;



    public ExpressionToObjectParser(ParsingUtilitiesService parsingService) {
        this.parsingService = parsingService;
    }


    public Expression parse(Object target, String expressionString)
            throws InvocationTargetException ,InstantiationException, IllegalAccessException
    {
        return parse(target, expressionString, new Expression(expressionString, _RootExpressionExtractor.class));
    }

    private Expression parse(Object target, String expressionString, Expression rootExpression)
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

        buildStringDerivedFields(stringDerivedFields, target, expressionString, rootExpression);
        buildStringDerivedArrayFields(stringDerivedArrayFields, target, expressionString, rootExpression);
        buildStringConstructedFields(stringConstructedFields, target, expressionString, rootExpression);
        buildStringConstructedArrayFields(stringConstructedArrayFields, target, expressionString, rootExpression);

        return rootExpression;
    }

    private void buildStringDerivedFields(List<Field> stringDerivedFields, Object target,
                                          String expressionString, Expression rootExpression)
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
                String extractedExpressionString = extractor.extractFromExpression(expressionString);
                Object fieldObject = provider.provide(extractedExpressionString);
                Expression derivedExpression = new Expression(extractedExpressionString, extractorClass);
                // TODO: 10/5/2023 test this
                if (stringDerivedField.isAnnotationPresent(AbstractType.class)){
                    derivedExpression.addDerivedExpression(new Expression(fieldObject.getClass().getTypeName(), _ConcreteTypeExtractor.class));
                }
                rootExpression.addDerivedExpression(derivedExpression);
                parse(fieldObject, extractedExpressionString, derivedExpression);
                stringDerivedField.set(target, fieldObject);
            }catch (IllegalArgumentException exception){
                throw new IncompatibleInstanceProviderException();
            }catch (IllegalAccessException ignored){}
        }
    }

    private void buildStringDerivedArrayFields(List<Field> stringDerivedArrayFields, Object target,
                                               String expressionString, Expression rootExpression)
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

            List<String> extractedExpressionStrings = extractor.extractArrayFromExpression(expressionString);
            ArrayList<Object> providedObjects = new ArrayList<>();
            for (String extractedExpressionString : extractedExpressionStrings) {
                Object object = provider.provide(extractedExpressionString);
                Expression derivedExpression = new Expression(extractedExpressionString, extractorCLass);
                // TODO: 10/5/2023 test this
                if (stringDerivedArrayField.isAnnotationPresent(AbstractType.class)){
                    derivedExpression.addDerivedExpression(new Expression(object.getClass().getTypeName(), _ConcreteTypeExtractor.class));
                }
                rootExpression.addDerivedExpression(derivedExpression);
                parse(object, expressionString, derivedExpression);
                providedObjects.add(object);
            }

            stringDerivedArrayField.setAccessible(true);
            try {
                stringDerivedArrayField.set(target, providedObjects);
            }catch (IllegalAccessException ignored){}

        }
    }

    private void buildStringConstructedFields(List<Field> stringConstructedFields, Object target,
                                              String expressionString, Expression rootExpression)
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

            String extractedExpressionString = extractor.extractFromExpression(expressionString);
            Object fieldObject = fieldConstructor.newInstance(extractedExpressionString);
            Expression derivedExpression = new Expression(extractedExpressionString,extractorCLass);
            rootExpression.addDerivedExpression(derivedExpression);
            parse(fieldObject, extractedExpressionString, derivedExpression);
            stringConstructedField.set(target, fieldObject);
        }
    }


    private void buildStringConstructedArrayFields(List<Field> stringConstructedArrayFields, Object target,
                                                   String expressionString, Expression rootExpression)
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
            List<String> extractedExpressionStrings = extractor.extractArrayFromExpression(expressionString);
            ArrayList<Object> constructedObjects = new ArrayList<>();
            for (String extractedExpressionString : extractedExpressionStrings) {
                Object constructedObject = arrayElementConstructor.newInstance(extractedExpressionString);
                Expression derivedExpression = new Expression(extractedExpressionString, extractorClass);
                rootExpression.addDerivedExpression(derivedExpression);
                parse(constructedObject, extractedExpressionString, derivedExpression);
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
