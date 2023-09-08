package base.parsing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionToObjectParserTest {
    ExpressionToObjectParser parser = new ExpressionToObjectParser(new DummyParsingService());


    @Test
    void simpleFields() throws Exception{

        SampleObject sampleObject = new SampleObject();
        parser.parse(sampleObject, "123456");

        assertEquals("23456", sampleObject.s);
        assertEquals(2, sampleObject.ss.size());
        assertEquals("23456", sampleObject.ss.get(0));
        assertEquals("3456", sampleObject.ss.get(1));

        assertEquals("23456", sampleObject.s2);
        assertEquals(2, sampleObject.ss2.size());
        assertEquals("23456", sampleObject.ss2.get(0));
        assertEquals("3456", sampleObject.ss2.get(1));
    }

    @Test
    void nestedFields()throws Exception{


        ComplexObject complexObject = new ComplexObject();
        parser.parse(complexObject, "123456");

        assertEquals("3456", complexObject.nested.s);
        assertEquals(2, complexObject.nested.ss.size());
        assertEquals("3456", complexObject.nested.ss.get(0));
        assertEquals("456", complexObject.nested.ss.get(1));

    }

    @Test
    void exceptions()throws Exception{
        FalseObject1 falseObject1 = new FalseObject1();
        FalseObject2 falseObject2 = new FalseObject2();
        FalseObject3 falseObject3 = new FalseObject3();
        FalseObject4 falseObject4 = new FalseObject4();

        assertThrowsExactly(ExpressionToObjectParser.IncompatibleInstanceProviderException.class,
                () -> parser.parse(falseObject1, "123456"));
        assertThrowsExactly(ExpressionToObjectParser.FieldIsNotArrayListException.class,
                () -> parser.parse(falseObject2, "123456"));
        assertThrowsExactly(ExpressionToObjectParser.FieldIsNotArrayListException.class,
                () -> parser.parse(falseObject3, "123456"));
        assertThrowsExactly(ExpressionToObjectParser.FieldHasNoStringConstructorException.class,
                () -> parser.parse(falseObject4, "123456"));
    }

    static class DummyExtractor extends ExpressionExtractor{

        @Override
        protected String extract(String expression) {
            return expression.substring(1);
        }

        @Override
        protected ExpressionNormalizer getNormalizer() {
            return s -> s;
        }
    }

    static class DummyArrayExtractor extends ExpressionArrayExtractor{

        @Override
        protected List<String> extract(String expression) {
            return List.of(expression.substring(1), expression.substring(2));
        }

        @Override
        protected ExpressionNormalizer getNormalizer() {
            return s -> s;
        }
    }

    static class StringProvider implements InstanceProvider{

        @Override
        public Object provide(String expression) {
            return expression;
        }
    }

    static class DummyParsingService implements ParsingUtilitiesService{

        @Override
        public ExpressionExtractor getExpressionExtractor(Class<? extends ExpressionExtractor> extractorClass) {
            return new DummyExtractor();
        }

        @Override
        public ExpressionArrayExtractor getExpressionArrayExtractor(Class<? extends ExpressionArrayExtractor> extractorClass) {
            return new DummyArrayExtractor();
        }

        @Override
        public InstanceProvider getInstanceProvider(Class<? extends InstanceProvider> providerClass) {
            return new StringProvider();
        }
    }

    static class SampleObject{
        @StringConstructed(extractor = DummyExtractor.class)
        String s;
        @StringConstructedArray(extractor = DummyArrayExtractor.class, of = String.class)
        ArrayList<String> ss;
        @StringDerived(extractor = DummyExtractor.class, provider = StringProvider.class)
        String s2;
        @StringDerivedArray(extractor = DummyArrayExtractor.class, provider = StringProvider.class)
        ArrayList<String> ss2;
    }

    static class NestedObject{
        @StringConstructed(extractor = DummyExtractor.class)
        String s;
        @StringConstructedArray(extractor = DummyArrayExtractor.class, of = String.class)
        ArrayList<String> ss;

        public NestedObject(String s){}
    }
    static class ComplexObject{
        @StringConstructed(extractor = DummyExtractor.class)
        NestedObject nested;
    }

    static class FalseObject1{
        @StringDerived(extractor = DummyExtractor.class, provider = StringProvider.class)
        Integer i;
    }

    static class FalseObject2{
        @StringDerivedArray(extractor = DummyArrayExtractor.class, provider = StringProvider.class)
        List<String> strings;
    }
    static class FalseObject3{
        @StringConstructedArray(extractor = DummyArrayExtractor.class, of = String.class)
        List<String> strings;
    }
    static class FalseObject4{
        @StringConstructed(extractor = DummyExtractor.class)
        HashMap map;
    }
}