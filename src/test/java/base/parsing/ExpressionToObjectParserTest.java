package base.parsing;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionToObjectParserTest {
    ExpressionToObjectParser parser = new ExpressionToObjectParser(new DummyParsingService());


    @Test
    void simpleFields() throws Exception{

        SimpleObject simpleObject = new SimpleObject();
        parser.parse(simpleObject, "123456");

        assertEquals("23456", simpleObject.s);
        assertEquals(2, simpleObject.ss.size());
        assertEquals("23456", simpleObject.ss.get(0));
        assertEquals("3456", simpleObject.ss.get(1));

        assertEquals("23456", simpleObject.s2);
        assertEquals(2, simpleObject.ss2.size());
        assertEquals("23456", simpleObject.ss2.get(0));
        assertEquals("3456", simpleObject.ss2.get(1));
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
    void ExpressionTree() throws Exception{
        Expression rootExpression = new Expression("123456", RootExpressionExtractor.class);
        Expression level1Expression = new Expression("23456", DummyExtractor.class);
        rootExpression.addDerivedExpression(level1Expression);
        Expression level2Expression1 = new Expression("3456", DummyExtractor.class);
        Expression level2Expression2 = new Expression("3456", DummyArrayExtractor.class);
        Expression level2Expression3 = new Expression("456", DummyArrayExtractor.class);
        level1Expression.addDerivedExpression(level2Expression1);
        level1Expression.addDerivedExpression(level2Expression2);
        level1Expression.addDerivedExpression(level2Expression3);

        ComplexObject complexObject = new ComplexObject();
        Expression computedRootExpression = parser.parse(complexObject, "123456");

       // rootExpression.equals(computedRootExpression);
        assertEquals(rootExpression, computedRootExpression);
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
        protected String normalize(String expression) {
            return expression;
        }
    }

    static class DummyArrayExtractor extends ExpressionArrayExtractor{

        @Override
        protected List<String> extract(String expression) {
            return List.of(expression.substring(1), expression.substring(2));
        }

        @Override
        protected String normalize(String expression) {
            return expression;
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

    static class SimpleObject {
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