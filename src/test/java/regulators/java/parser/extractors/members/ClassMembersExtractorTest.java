package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassMembersExtractorTest {
    ClassMembersExtractor extractor = new ClassMembersExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("class cls{}"));
        assertIterableEquals(List.of("s1;", "s2;", "s3;", "s4  ;", "s5 s6;", "s7\ts8s9"),
                extractor.extractArrayFromExpression("class cls{s1; s2; \ns3; \t s4  ; s5 s6; s7\ts8s9         }"));

        assertIterableEquals(List.of("{1}", ", {2}", "{\n3\n\t}", "{{4}{5}}"), extractor.extractArrayFromExpression("private static class cls {{1}, {2}\n\n{\n3\n\t} {{4}{5}}}"));
        assertIterableEquals(List.of("s1;", "{1}", "{2}", ";", "s2  ;", "{3}",  "s3 {4}"), extractor.extractArrayFromExpression("class cls{s1; {1}{2}; s2  ; {3} s3 {4} }"));
        assertIterableEquals(List.of("{1}", "s1;", "{2}"), extractor.extractArrayFromExpression("class s{{1} s1; {2}\n}"));

        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("{}"));
        assertIterableEquals(List.of("s1;"), extractor.extractArrayFromExpression("class {s1;}"));
        assertIterableEquals(List.of("1"), extractor.extractArrayFromExpression("{\n1\n }"));
        assertIterableEquals(List.of("s1;", "1"), extractor.extractArrayFromExpression("{s1;1}"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("class cls{"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("class cls<{T> {s1;}"));
    }
}