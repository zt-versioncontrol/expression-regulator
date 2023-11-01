package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnumMembersExtractorTest {

    EnumMembersExtractor extractor = new EnumMembersExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("enum en{}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("enum en {A, B}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("static enum en{A, B, C;}"));
        assertIterableEquals(List.of("string s;"), extractor.extractArrayFromExpression("enum\nen\n{; string s;}"));
        assertIterableEquals(List.of(";", "s1;", "s2 ;", "s3\n;", "s4,s5;", "s6 \ns7"),
                extractor.extractArrayFromExpression("public enum{;; s1;   s2 ;\ns3\n; s4,s5; s6 \ns7}"));

        assertIterableEquals(List.of("s1;", "s2{1}", ";", "{2}", ",{3}", "s3;", "{4}", "{{5}{6}}", "s4\ts5"),
                extractor.extractArrayFromExpression("private enum en{A, B; s1; s2{1}; {2},{3} s3; {4} {{5}{6}} s4\ts5   }"));


        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("{}"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("enum en{; S1"));
        assertIterableEquals(List.of("s1;"), extractor.extractArrayFromExpression("{A,B; s1;}"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("enum en{A; {1}}{}"));
        assertIterableEquals(List.of("s1"), extractor.extractArrayFromExpression("enum e implements T<{String ; s1}"));
    }
}