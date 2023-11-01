package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImportsExtractorTest {

    ImportsExtractor extractor = new ImportsExtractor();

    @Test
    void extractArrayFromExpression() {

        assertIterableEquals(List.of(), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of("import l.r.t;", "import q;"),
                extractor.extractArrayFromExpression("package k;\n import l.r.t; import q;"));

        assertIterableEquals(List.of("import\nk.l;", "import i;"),
                extractor.extractArrayFromExpression("import\nk.l; import i; class x{}; interface I{}"));

        assertIterableEquals(List.of("import r;"),
                extractor.extractArrayFromExpression("package pkg; import r;;\nclass R{xxx};"));

        assertIterableEquals(List.of("import r;", ";", "import T;"),
                extractor.extractArrayFromExpression("package pkg; import r;;import T;\nclass R{xxx};"));

        assertIterableEquals(List.of("i1;", "i2;", "i3"), extractor.extractArrayFromExpression("i1; i2; i3"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("package k\n import l;"));
        assertIterableEquals(List.of("import r;"), extractor.extractArrayFromExpression("import r; import k\n class cls{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("import T\nclass cls{}"));
        assertIterableEquals(List.of("package"), extractor.extractArrayFromExpression("package"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("class cls{}\nimport t;"));
        assertIterableEquals(List.of("import k;", "package pkg;"), extractor.extractArrayFromExpression("import k; package pkg;"));
    }
}