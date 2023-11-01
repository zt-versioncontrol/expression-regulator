package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterTypeExtractorTest {

    ParameterTypeExtractor extractor = new ParameterTypeExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("int", extractor.extractFromExpression("int k"));
        assertEquals("List <String>", extractor.extractFromExpression("List<String>lst"));
        assertEquals("List <String>", extractor.extractFromExpression("List<String>\nlst"));
        assertEquals("List <String>", extractor.extractFromExpression("List<String>     lst"));
        assertEquals("List <String >", extractor.extractFromExpression("List<String >lst"));


        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("String String", extractor.extractFromExpression("String String str"));
        assertEquals("Map <String,", extractor.extractFromExpression("Map<String, List>"));
        assertEquals("Map", extractor.extractFromExpression("Map<String,List>"));
        assertEquals("String", extractor.extractFromExpression("String"));
        assertEquals("List", extractor.extractFromExpression("List<String>"));
    }
}