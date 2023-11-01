package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumIdentifierExtractorTest {

    EnumIdentifierExtractor extractor = new EnumIdentifierExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("cls", extractor.extractFromExpression("public enum cls{}"));
        assertEquals("cls", extractor.extractFromExpression("enum cls{}"));
        assertEquals("cls", extractor.extractFromExpression("public enum cls{asdaqwe\n\nqwe \t\t\t\\n\n{}{{}}}"));
        assertEquals("cls", extractor.extractFromExpression("public static    enum cls implements   Y{}"));

        //invalid expression but have enough structure to extract identifier
        assertEquals("cls<T>", extractor.extractFromExpression("public \n  enum cls<T>{}"));
        assertEquals("cls", extractor.extractFromExpression("public enum cls <T> extends X{}"));
        assertEquals("cls", extractor.extractFromExpression("public enum cls <T> implements   Y{}"));
        assertEquals("cls", extractor.extractFromExpression("public static enum \n\n\tcls\n<T> extends X implements Y{}"));
        assertEquals("cls", extractor.extractFromExpression("enum cls"));
        assertEquals("cls", extractor.extractFromExpression("enum cls asdasda"));
        assertEquals("<", extractor.extractFromExpression("enum < cls>"));
        assertEquals("<cls>", extractor.extractFromExpression("enum <cls>"));
        assertEquals("", extractor.extractFromExpression("enum"));
        assertEquals("", extractor.extractFromExpression("enum {}"));
        assertEquals("", extractor.extractFromExpression("public static void <> ()<>T enum {}"));

        //invalid expressions
        //particular result is not important
        assertEquals("", extractor.extractFromExpression("public {}enum cls{}"));
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("\n\n\n"));
        assertEquals("", extractor.extractFromExpression("{}"));
        assertEquals("", extractor.extractFromExpression("{public enum cls"));
        assertEquals("", extractor.extractFromExpression("public class cls{}"));
    }
}