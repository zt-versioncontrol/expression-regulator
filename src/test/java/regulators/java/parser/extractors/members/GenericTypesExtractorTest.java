package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericTypesExtractorTest {

    GenericTypesExtractor extractor = new GenericTypesExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of("T", "R", "G"), extractor.extractArrayFromExpression("<\n\n\nT, R, G     >"));
        assertIterableEquals(List.of("T extends Map<String,\nInteger>", "R", "Q", "Y \nextends\t List<String>"),
                extractor.extractArrayFromExpression("<T extends Map<String,\nInteger>,  \n\n\nR, Q, \t   Y \nextends\t List<String>>"));

        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("<>"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("<T, R"));
        assertIterableEquals(List.of("T extends L<R"), extractor.extractArrayFromExpression("<T extends L<R  >"));
        assertIterableEquals(List.of("<T>"), extractor.extractArrayFromExpression("<<T>>"));
        assertIterableEquals(List.of("GT", "l< T, R"), extractor.extractArrayFromExpression("<  GT, l< T, R >"));
    }
}