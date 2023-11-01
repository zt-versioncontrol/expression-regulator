package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassQualifiersExtractorTest {

    ClassQualifiersExtractor extractor = new ClassQualifiersExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of("public"), extractor.extractArrayFromExpression("\t\npublic class cls{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("\t class\n cls{}"));
        assertIterableEquals(List.of("public", "static"), extractor.extractArrayFromExpression("public\n   static\t class \ncls implements\n I\n{\n}"));
        assertIterableEquals(List.of("public", "static", "Q1", "Q2", "Q4"), extractor.extractArrayFromExpression("public static Q1   Q2 Q4 class cls extends S implements I{abc}"));

        //invalid expressions but have enough structure to extract expressions
        assertIterableEquals(List.of("public"), extractor.extractArrayFromExpression("public class cls"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("{public class cls"));
        assertIterableEquals(List.of("<", "ABC", ">"), extractor.extractArrayFromExpression("< ABC > class"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of("public"), extractor.extractArrayFromExpression("public class"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("xx{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("class clss"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("public CLASS"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("public enum En{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("public interface I{}"));
    }
}