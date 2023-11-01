package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnumQualifiersExtractorTest {
    EnumQualifiersExtractor extractor = new EnumQualifiersExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("enum en{}"));
        assertIterableEquals(List.of("private", "static"), extractor.extractArrayFromExpression("private   \n\tstatic    enum en{A,B,C;}"));
        assertIterableEquals(List.of("public"), extractor.extractArrayFromExpression("\n\npublic enum En{A, B,C;}"));

        //invalid expressions but have enough structure to extract from
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of("public"), extractor.extractArrayFromExpression("public enum {}"));
        assertIterableEquals(List.of("static"), extractor.extractArrayFromExpression("static enum <T>"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("enum"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("{}"));

        //invalid expressions
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("public static class cls{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("static interface En{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("public {enum    En{}"));
        assertIterableEquals(List.of("<", "T", ">"), extractor.extractArrayFromExpression("< T\n > enum en{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("{private enum En{}"));
        assertIterableEquals(List.of("(", ")", "()", "private"), extractor.extractArrayFromExpression("( ) () private enum En{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("public Enum E{}"));


    }
}