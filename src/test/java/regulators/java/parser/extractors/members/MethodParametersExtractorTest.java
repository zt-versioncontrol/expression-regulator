package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodParametersExtractorTest {

    MethodParametersExtractor extractor  = new MethodParametersExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun(){}"));
        assertIterableEquals(List.of("String s"), extractor.extractArrayFromExpression("int fun(String s){}"));
        assertIterableEquals(List.of("Map<String, Boolean> map", "List\n\n<String> lst", "int i"),
                extractor.extractArrayFromExpression("private static Map<String, Integer> fun(Map<String, Boolean> map, List\n\n<String> lst,\n \nint i)"));


        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of("Integer k"), extractor.extractArrayFromExpression("(Integer k)"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("(int i"));
        assertIterableEquals(List.of("{String s"), extractor.extractArrayFromExpression("void fun({String s){}"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("int {fun(String s){}"));
        assertIterableEquals(List.of("int i", "String s"), extractor.extractArrayFromExpression("(int i, String s) void fun"));
    }
}