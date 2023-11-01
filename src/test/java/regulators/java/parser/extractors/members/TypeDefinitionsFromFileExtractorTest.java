package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeDefinitionsFromFileExtractorTest {

    TypeDefinitionsFromFileExtractor extractor = new TypeDefinitionsFromFileExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of("{1}", "xxx\n{2}", "x{3}", "xxx; \t{4}", "; {5}"),
                extractor.extractArrayFromExpression("a; a; c; {1} xxx\n{2}\n x{3}xxx; \t{4}; {5};"));

        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of("package pkg\n class cls{}"), extractor.extractArrayFromExpression("\npackage pkg\n class cls{}\n\n"));
        assertIterableEquals(List.of("{1}", "{2 {3} {4}"), extractor.extractArrayFromExpression("{1} {2 {3} {4}"));
        assertIterableEquals(List.of("} {1}", "{2}"), extractor.extractArrayFromExpression("} {1} {2}"));
        assertIterableEquals(List.of("{{1}{2}}"), extractor.extractArrayFromExpression("{{1}{2}}"));
    }
}