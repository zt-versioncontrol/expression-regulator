package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImplementedInterfaceTypesExtractorTest {

    ImplementedInterfaceTypesExtractor extractor = new ImplementedInterfaceTypesExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of("A"), extractor.extractArrayFromExpression("implements A"));
        assertIterableEquals(List.of("A", "B"), extractor.extractArrayFromExpression("implements \nA,    B   "));
        assertIterableEquals(List.of("A<Integer, String>", "B<List\n<Integer>>"), extractor.extractArrayFromExpression("implements \nA<Integer, String>,    B<List\n<Integer>>   "));

        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("A"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(" implements A"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("\nimplements A"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("implements "));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("implements"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("Implements A"));
        assertIterableEquals(List.of("T<, Q<T>"), extractor.extractArrayFromExpression("implements T<, Q<T>"));
        assertIterableEquals(List.of("T<, Q<T>> R"), extractor.extractArrayFromExpression("implements T<, Q<T>> R"));
        assertIterableEquals(List.of("T<, Q<T>>", "R"), extractor.extractArrayFromExpression("implements T<, Q<T>>, R"));
    }
}