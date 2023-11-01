package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnumConstantsExtractorTest {

    EnumConstantsExtractor extractor = new EnumConstantsExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of("A", "B", "C"), extractor.extractArrayFromExpression("enum en{A,B,\tC;}"));
        assertIterableEquals(List.of("A", "B", "C"), extractor.extractArrayFromExpression("enum en{A,B,   C}"));
        assertIterableEquals(List.of("A", "A1"), extractor.extractArrayFromExpression("private enum en{A, A1; string s; class cls{}}"));

        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of("A", "B"), extractor.extractArrayFromExpression("{A, B}"));
        assertIterableEquals(List.of("int k"), extractor.extractArrayFromExpression("enum en{int k; A, B;}"));
        assertIterableEquals(List.of("int  \nk"), extractor.extractArrayFromExpression("enum en{int  \nk; A, B}"));
        assertIterableEquals(List.of("A B C"), extractor.extractArrayFromExpression("enum en{A B C;;}"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("enum en{}{}"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("enum en{A, B;"));
    }
}