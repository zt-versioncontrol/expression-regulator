package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceQualifiersExtractorTest {

    InterfaceQualifiersExtractor extractor = new InterfaceQualifiersExtractor();

    @Test
    void extractArrayFromExpression() {
        assertEquals(List.of(), extractor.extractArrayFromExpression("interface I{}"));
        assertEquals(List.of("private"), extractor.extractArrayFromExpression("private interface K{}"));
        assertEquals(List.of("public", "static", "final"), extractor.extractArrayFromExpression("public static final interface Inter{}"));
        assertEquals(List.of("public"), extractor.extractArrayFromExpression("public interface I<T> {}"));
        assertEquals(List.of(), extractor.extractArrayFromExpression("interface P<t> extends I2"));


        assertEquals(List.of(), extractor.extractArrayFromExpression(""));
        assertEquals(List.of("<public>"), extractor.extractArrayFromExpression("<public> interface KK{}"));
        assertEquals(List.of("<", "public", ">"), extractor.extractArrayFromExpression("< public > interface L{}"));
        assertEquals(List.of("<", "public"), extractor.extractArrayFromExpression("< public interface L{}"));
        assertEquals(List.of(), extractor.extractArrayFromExpression("public xxx T{}"));
        assertEquals(List.of(), extractor.extractArrayFromExpression("public static class cls{}"));
        assertEquals(List.of("public"), extractor.extractArrayFromExpression("public interface"));
        assertEquals(List.of(), extractor.extractArrayFromExpression("interface public Inter{}"));
        assertEquals(List.of(), extractor.extractArrayFromExpression("{public interface K{}"));
        assertEquals(List.of(), extractor.extractArrayFromExpression("{}public interface K{}"));
        assertEquals(List.of(), extractor.extractArrayFromExpression("{public} interface K{}"));
    }
}