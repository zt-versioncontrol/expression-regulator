package regulators.java.parser.extractors.logic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatementsExtractorTest {

    StatementsExtractor extractor = new StatementsExtractor();

    @Test
    void extractArrayFromExpression() {
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun(){}"));
        assertIterableEquals(List.of(), extractor.extractArrayFromExpression("void fun(){     }"));
        assertIterableEquals(List.of("s1;", "s2;", "s3;", "s4;", "s5  ;", "s6\n\t;", "s7 s8 \n\ts9"),
                extractor.extractArrayFromExpression("void fun(){s1;s2;\n\ns3;\n\ts4;   s5  ;s6\n\t;  s7 s8 \n\ts9}"));

        assertIterableEquals(List.of("{1}", "{\n2}", "{3}", "{\t4\n}", "{5}", "{{{{6}}}}", "{{7} {8}}"),
                extractor.extractArrayFromExpression("String fun(int i){{1}{\n2}  \t{3}\n{\t4\n}  {5}{{{{6}}}}{{7} {8}}    }"));

        assertIterableEquals(List.of("1s;", "{1}", "{2}", ";", "2s;", "3s ;", "{3}", "4s;", "5s;", "{4}"),
                extractor.extractArrayFromExpression("static int fun(xx{x){  1s; {1}{2};2s; \n\n3s ; {3}\t\n 4s;5s; {4}      }"));

        assertIterableEquals(List.of("{1}", "1s;"), extractor.extractArrayFromExpression("static int fun(xx{x){ {1} 1s; }"));


        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression(""));
        assertIterableEquals(List.of("s1;"), extractor.extractArrayFromExpression("{s1;}"));
        assertIterableEquals(List.of("(){}"), extractor.extractArrayFromExpression("{(){}}"));
        assertIterableEquals(List.of(";"), extractor.extractArrayFromExpression("void fun{;}"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("void fun(){s1;}abc"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("void fun(){s1;} "));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("void fun(){s1;"));
        assertIterableEquals(List.of(""), extractor.extractArrayFromExpression("void fun(){{}{}"));
    }
}