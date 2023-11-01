package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassIdentifierExtractorTest {

    ClassIdentifierExtractor extractor = new ClassIdentifierExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("cls", extractor.extractFromExpression("public class cls{}"));
        assertEquals("cls", extractor.extractFromExpression("public class cls{asdaqwe\n\nqwe \t\t\t\\n\n{}{{}}}"));
        assertEquals("cls", extractor.extractFromExpression("public \n  class cls<T>{}"));
        assertEquals("cls", extractor.extractFromExpression("public class cls <T> extends X{}"));
        assertEquals("cls", extractor.extractFromExpression("public class cls <T> implements   Y{}"));
        assertEquals("cls", extractor.extractFromExpression("public static class \n\n\tcls\n<T> extends X implements Y{}"));

        //invalid expression but have enough structure to extract identifier
        assertEquals("cls", extractor.extractFromExpression("class cls"));
        assertEquals("cls", extractor.extractFromExpression("class cls asdasda"));
        assertEquals("<", extractor.extractFromExpression("class < cls>"));
        assertEquals("<cls>", extractor.extractFromExpression("class <cls>"));
        assertEquals("", extractor.extractFromExpression("class"));
        assertEquals("", extractor.extractFromExpression("class {}"));
        assertEquals("", extractor.extractFromExpression("public static void <> ()<>T class {}"));

        //invalid expressions
        //particular result is not important
        assertEquals("", extractor.extractFromExpression("public {}class cls{}"));
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("\n\n\n"));
        assertEquals("", extractor.extractFromExpression("{}"));
        assertEquals("", extractor.extractFromExpression("{public class cls"));
        assertEquals("", extractor.extractFromExpression("public interface cls{}"));
        assertEquals("", extractor.extractFromExpression("public enum E{}"));

    }
}