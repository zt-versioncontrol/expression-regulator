package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericTypesSelectorsExtractorTest {

    GenericTypesSelectorsExtractor extractor = new GenericTypesSelectorsExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("String"));
        assertIterableEquals(List.of("String"), extractor.extractArrayFromExpression("List\t<\n\tString\n\t>"));
        assertIterableEquals(List.of("String", "Integer"), extractor.extractArrayFromExpression("Map<String, Integer>"));
        assertIterableEquals(List.of("Map<String, List<String>>", "Integer"), extractor.extractArrayFromExpression("Map<Map<String, List<String>>, Integer>"));

        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("List<String"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("T<R><X>"));
        assertIterableEquals(List.of("R", "", "", "E"), extractor.extractArrayFromExpression("T<R, \n,,E>"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("T<>"));
    }
}