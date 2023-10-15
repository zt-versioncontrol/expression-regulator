package regulators.json.parser.extractors;

import org.junit.jupiter.api.Test;
import regulators.json.parser.extractors.PropertiesExtractor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PropertiesExtractorTest {

    @Test
    void extractArrayFromExpression() {
        PropertiesExtractor extractor = new PropertiesExtractor();

        //simple case
        assertIterableEquals(
                List.of("\"a,b,c\": 3", "def", "\"ghi\": \"z,z,z\"", "jkl"),
                extractor.extractArrayFromExpression("{\"a,b,c\": 3, def, \"ghi\": \"z,z,z\", jkl\n}"));
        //blank array elements
        assertIterableEquals(
                List.of("abc", "", "", ""),
                extractor.extractArrayFromExpression("{ abc, ,    , \s\t\n}"));
        //elements that contain simple scopes
        assertIterableEquals(
                List.of("\"abc, def\"", "{\nghi,  jkl\n}", "[mno, pqr]", "'s", "tu","'", "z"),
                extractor.extractArrayFromExpression("{ \"abc, def\" , {\nghi,  jkl\n}, [mno, pqr], 's,tu,', z}"));
        //elements that contain intersected scopes
        assertIterableEquals(
                List.of("{,[,}", "]", "\"{,a}[,{,gr},],{,]\"", "{\"ttt,\"[,}", "]"),
                extractor.extractArrayFromExpression("{{,[,},], \"{,a}[,{,gr},],{,]\", {\"ttt,\"[,}, ]}"));
        //embedded quotes and some invalid elements
        assertIterableEquals(
                List.of("\"a,\\\"b,\\\"c,\"", "\" z\n'z'z\n\"", "\"e,f.g\"\"3,3,3\"", "{,}{[,]}"),
                extractor.extractArrayFromExpression("{\"a,\\\"b,\\\"c,\", \" z\n'z'z\n\", \"e,f.g\"\"3,3,3\", {,}{[,]}}"));


        //invalid inputs
        assertEquals(1, extractor.extractArrayFromExpression(" {1,2,3,4,5} ").size());
        assertNotEquals("11", extractor.extractArrayFromExpression("11,22,33,44}").get(0));
        assertNotEquals("44", extractor.extractArrayFromExpression("{11,22,33,44").get(3));



    }

}