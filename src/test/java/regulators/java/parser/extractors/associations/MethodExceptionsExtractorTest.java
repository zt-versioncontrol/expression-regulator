package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodExceptionsExtractorTest {

    MethodExceptionsExtractor extractor = new MethodExceptionsExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun(String s){}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun(String s);"));
        assertIterableEquals(List.of("Exception"), extractor.extractArrayFromExpression("public String \nfun(List<String> l)throws Exception{\t\nreturn \t\"abc\";\n}"));
        assertIterableEquals(List.of("Exception"), extractor.extractArrayFromExpression("public String \nfun(List<String> l)throws Exception;"));
        assertIterableEquals(List.of("Exception", "RunTimeException"), extractor.extractArrayFromExpression("public static String \nfun()throws Exception, RunTimeException{\t\nreturn \t\"abc\";\n}"));
        assertIterableEquals(List.of("Exception", "RunTimeException"), extractor.extractArrayFromExpression("public static String \nfun()throws Exception, RunTimeException;"));

        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("()"));
        //must end with semi colon if abstract
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("void fun()throws exception"));
        assertIterableEquals(List.of("exception", "anotherException"), extractor.extractArrayFromExpression("()throws exception, anotherException;"));
        assertIterableEquals(List.of("E"), extractor.extractArrayFromExpression("void fun()\nthrows E {}{}ee"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun(){} throws Exception"));
        assertIterableEquals(List.of("Exception"), extractor.extractArrayFromExpression("void fun()throws Exception{} throws Exception"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("void fun() Exception{}"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("thorws Exception;"));
        assertIterableEquals(List.of("exception runtimeException"), extractor.extractArrayFromExpression("void fun() throws exception runtimeException{}"));
    }
}