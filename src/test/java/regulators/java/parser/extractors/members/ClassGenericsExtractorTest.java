package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;
import regulators.java.parser.extractors.members.ClassGenericsExtractor;

import static org.junit.jupiter.api.Assertions.*;

class ClassGenericsExtractorTest {
    private ClassGenericsExtractor extractor = new ClassGenericsExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("<G1,G2, G3>", extractor.extractFromExpression("class cls<G1,G2, G3>\n{}"));
        assertEquals("<G1,G2, G3>", extractor.extractFromExpression("public static class cls<G1,G2, G3>{}"));
        assertEquals("<G1,G2, G3>", extractor.extractFromExpression("public \nstatic class \ncls\n<G1,G2, G3> extends S1 implements I1{}"));
        //extractor has neglected side effect on space characters
        assertEquals("<G1 ,G2 ,G3>", extractor.extractFromExpression("public \nstatic class \ncls\n<G1\n,G2\n\n  ,G3> implements I1{}"));
        assertEquals("", extractor.extractFromExpression("class cls  {}"));
        assertEquals("", extractor.extractFromExpression("class cls implements I{}"));
        assertEquals("", extractor.extractFromExpression("class cls extends S{}"));
        assertEquals("", extractor.extractFromExpression("class cls extends S implements I{}"));


        //if extends or implements clause is not completed, it is taken as part of generics
        assertEquals("<G1,G2,G3> implements", extractor.extractFromExpression("class cls<G1,G2,G3> \nimplements  "));
        assertEquals("<G1,G2,G3> extends", extractor.extractFromExpression("class cls<G1,G2,G3>extends "));

        //invalid expressions, but have sufficient structure to extract generics from
        assertEquals("<G1,G2,G3> zzz", extractor.extractFromExpression("class cls<G1,G2,G3>zzz{}"));
        assertEquals("<G1,G2, G3>", extractor.extractFromExpression("class cls<G1,G2, G3>"));
        assertEquals("class G1,G2, G3", extractor.extractFromExpression("class cls class G1,G2, G3"));
        assertEquals("cls <G1,G2, G3>", extractor.extractFromExpression("class <T>cls<G1,G2, G3>"));
        assertEquals("<G1,G2, G3>", extractor.extractFromExpression("<abc><efg>class cls<G1,G2, G3>"));
        assertEquals("<G1,G2, G3>", extractor.extractFromExpression("class cls<G1,G2, G3>{"));
        assertEquals("<G1,G2, G3>", extractor.extractFromExpression("class cls<G1,G2, G3>{{{{"));
        assertEquals("<G1,G2, G3> }", extractor.extractFromExpression("class cls<G1,G2, G3>}"));
        assertEquals("<G1,G2, G3> ()}", extractor.extractFromExpression("class cls<G1,G2, G3>()}"));

        //invalid expressions.
        //the particular result is not important as long as the result is invalid expression
        assertEquals("", extractor.extractFromExpression("cls<G1,G2, G3>}"));
        assertEquals("G3>", extractor.extractFromExpression("class <G1,G2, G3>{}"));
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("{class cls<G1,G2, G3>"));
        assertEquals("", extractor.extractFromExpression("interface cls <G1,G2, G3>{}"));


        //tricky cases
        assertEquals("", extractor.extractFromExpression("<class> cls<T>"));
        assertEquals("< extends > k", extractor.extractFromExpression("class cls < extends > k"));
        assertEquals("< implements >", extractor.extractFromExpression("class cls < implements > extends k"));
        assertEquals("< extends implements >", extractor.extractFromExpression("class cls < extends\nimplements > extends k"));

    }
}