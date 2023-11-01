package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodQualifiersExtractorTest {

    MethodQualifiersExtractor extractor = new MethodQualifiersExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun(){}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun();"));
        assertIterableEquals(List.of("public", "static"), extractor.extractArrayFromExpression("public\n static\nvoid   fun()\n{}"));
        assertIterableEquals(List.of("public", "static"), extractor.extractArrayFromExpression("public\n static\nvoid   fun()\n;"));
        assertIterableEquals(List.of("public", "final"), extractor.extractArrayFromExpression("public final List<String> f(){ return null;}"));
        assertIterableEquals(List.of("public", "final"), extractor.extractArrayFromExpression("public final List<String> f();"));
        assertIterableEquals(List.of("public", "static"), extractor.extractArrayFromExpression("public static <T extends List<Double>> Map<List<Integer>, String> fun(){return null;}"));
        assertIterableEquals(List.of("public", "static"), extractor.extractArrayFromExpression("public static <T extends List<Double>> Map<List<Integer>, String> fun();"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(" <T extends List<Double>> Map <\nList <Integer> , String   >\t fun(){return null;}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(" <T extends List<Double>> Map <\nList <Integer> , String   >\t fun();"));


        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun()"));
        assertIterableEquals(List.of("public", "static"), extractor.extractArrayFromExpression("public\n static\nvoid   fun()\n"));

        assertIterableEquals(List.of("<T1>"), extractor.extractArrayFromExpression("<T1> <T2> List<Boolean> fun()"));
        assertIterableEquals(List.of("< T1 >"), extractor.extractArrayFromExpression("< T1 > <T2> List<Boolean> fun()"));
        assertIterableEquals(List.of("<T1>", "T2"), extractor.extractArrayFromExpression("<T1> T2 List<Boolean> fun()"));
        assertIterableEquals(List.of("<T1>", "T2"), extractor.extractArrayFromExpression("<T1> T2 <List><Boolean> fun()"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(" <\nList> <Boolean> fun()"));
    }
}