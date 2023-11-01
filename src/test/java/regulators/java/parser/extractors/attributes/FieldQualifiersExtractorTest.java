package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldQualifiersExtractorTest {

    FieldQualifiersExtractor extractor = new FieldQualifiersExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of("public", "static"), extractor.extractArrayFromExpression("public \nstatic String s;"));
        assertIterableEquals(List.of("static"), extractor.extractArrayFromExpression("static String s = \"abc\"\n;"));
        assertIterableEquals(List.of("private", "final", "static"), extractor.extractArrayFromExpression("private   final static List<Integer> lst;"));
        assertIterableEquals(List.of("private", "final", "static"), extractor.extractArrayFromExpression("private final   static\tList < List < String > > lst;"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("String s;"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("List < List < String > > lst = null;"));


        //missing semicolon
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("public \nstatic String s"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(";"));
        assertIterableEquals(List.of("public", "<String>"), extractor.extractArrayFromExpression("public <String> string s;"));
        assertIterableEquals(List.of("public", "< String>"), extractor.extractArrayFromExpression("public < String> string s;"));
        assertIterableEquals(List.of("<string>", "<string>"), extractor.extractArrayFromExpression("<string><string><string><string> s;"));
        assertIterableEquals(List.of("<string >", "<string>"), extractor.extractArrayFromExpression("<string ><string><string><string> s;"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(";"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
    }
}