package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedInterfaceTypesExtractorTest {

    ExtendedInterfaceTypesExtractor extractor = new ExtendedInterfaceTypesExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of("I1"), extractor.extractArrayFromExpression("extends I1"));
        assertIterableEquals(List.of("i1", "I2", "i3"), extractor.extractArrayFromExpression("extends i1, \tI2,\n\t\ti3"));
        assertIterableEquals(List.of("i1", "I2", "i3"), extractor.extractArrayFromExpression("extends i1, \tI2,\n\t\ti3\n\t    "));

        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("I1"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("I1, I2"));
        assertIterableEquals(List.of("I1 implements i2"), extractor.extractArrayFromExpression("extends I1 implements i2"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(" extends I1"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("implements k"));
    }
}