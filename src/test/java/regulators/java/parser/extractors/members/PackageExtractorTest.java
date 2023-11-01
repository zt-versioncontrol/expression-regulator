package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageExtractorTest {

    PackageExtractor extractor = new PackageExtractor();

    @Test
    void extractFromExpression() {

        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("package \npkg;", extractor.extractFromExpression("\n\n\tpackage \npkg; import R; class clas"));
        assertEquals("package pkg\n class cls", extractor.extractFromExpression("  package pkg\n class cls\n"));
        assertEquals("", extractor.extractFromExpression("import l;"));
        assertEquals("", extractor.extractFromExpression("class cls{}\npackage k"));
    }
}