package regulators.json.parser;

import base.drivers.parsing.ExecutionReport;
import base.drivers.parsing.ReportingService;
import base.expressions.Expression;
import base.parsing._ConcreteTypeExtractor;
import base.parsing._RootExpressionExtractor;
import org.junit.jupiter.api.Test;
import regulators.json.parser.extractors.JsonExtractor;
import regulators.json.parser.parsedObjects.*;
import regulators.json.parser.validation.validators.JsonInvalidValidator;
import regulators.json.parser.validation.validators.PropertyNameValidator;
import regulators.json.parser.validation.validators.PropertyValidator;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    DummyReportingService service = new DummyReportingService();
    JsonParser parser = new JsonParser(service);

    @Test
    void primitiveCases() {


        String invalid1 = "";
        String invalid2 = "abc";
        String binary1 = "true";
        String binary2 = "false";
        String nul = "null";
        String object = "{}";
        String array = "[]";


        Json json;
        Expression concreteTypeExpression;
        Expression jsonExpression;
        Expression root;

        json = parser.parse(invalid1);


        concreteTypeExpression = new Expression(JsonInvalid.class.getTypeName(), _ConcreteTypeExtractor.class);
        jsonExpression = new Expression("", JsonExtractor.class);
        root = new Expression("", _RootExpressionExtractor.class);
        root.addDerivedExpression(jsonExpression);
        jsonExpression.addDerivedExpression(concreteTypeExpression);
        assertTrue(json instanceof JsonInvalid);
        assertEquals(root, service.report.expressionTree);
        assertEquals(1, service.report.invalidations.size());
        assertEquals(JsonInvalidValidator.class, service.report.invalidations.get(0).validator);


        concreteTypeExpression = new Expression(JsonInvalid.class.getTypeName(), _ConcreteTypeExtractor.class);
        jsonExpression = new Expression("abc", JsonExtractor.class);
        root = new Expression("abc", _RootExpressionExtractor.class);
        root.addDerivedExpression(jsonExpression);
        jsonExpression.addDerivedExpression(concreteTypeExpression);
        json = parser.parse(invalid2);
        assertTrue(json instanceof JsonInvalid);
        assertEquals(root, service.report.expressionTree);

        assertEquals(true, ((JsonBinary) parser.parse(binary1)).getValue());
        assertEquals(0, service.report.invalidations.size());
        assertEquals(false, ((JsonBinary) parser.parse(binary2)).getValue());
        assertEquals(0, service.report.invalidations.size());
        assertTrue(parser.parse(nul) instanceof JsonNull);
        assertEquals(0, service.report.invalidations.size());
        assertTrue(parser.parse(object) instanceof JsonObject);
        assertEquals(0, service.report.invalidations.size());
        assertTrue(parser.parse(array) instanceof JsonArray);
        assertEquals(0, service.report.invalidations.size());

    }

    @Test
    void advancedCase() {
        String sampleJson = " \n{\"a\": [1,3,4,5], \"b\": {\"x\": 45, \"y\": 23, \"z\": false}, \"c\": 5, \"d\": \"str\", \"e\": true, \"f\": null, \"g\":[}@#3}\n";

        JsonObject json = (JsonObject) parser.parse(sampleJson);
        NavigationAssistant navigator = new NavigationAssistant(json);;

        assertEquals(7, json.getProperties().size());

        navigator.reset();
        assertEquals(4, navigator.getProperty(0).getElement(2).asNumber().getValue());
        assertTrue(json.getProperties().get(1).getValue() instanceof JsonObject);
        navigator.reset();
        assertEquals(5, navigator.getProperty(2).asNumber().getValue());
        navigator.reset();
        assertEquals("str", navigator.getProperty(3).asString().getValue());
        navigator.reset();
        assertEquals(true, navigator.getProperty(4).asBinary().getValue());
        navigator.reset();
        assertDoesNotThrow(() -> navigator.getProperty(5).asNull());
        navigator.reset();
        assertDoesNotThrow(() -> navigator.getProperty(6).asInvalid());

        assertEquals("\"g\"", json.getProperties().get(6).getName());

        assertEquals(1, service.report.invalidations.size());
        assertEquals(JsonInvalidValidator.class, service.report.invalidations.get(0).validator);
        assertEquals("[}@#3" , service.report.invalidations.get(0).invalidExpression.getExpressionString());

        //this assertion heavily depends on how ExpressionToObjectParser works and might be removed if it caused problems
        assertEquals("{\"x\": 45, \"y\": 23, \"z\": false}",
                service.report.expressionTree.getDerivedExpressions().get(0).getDerivedExpressions().get(2).getDerivedExpressions().get(0).getExpressionString());
    }

    @Test
    void complexCase() {
        runColmplexCase(SampleData.INDENTED_JSON);
        runColmplexCase(SampleData.MINIFIED_JSON);
    }

    void runColmplexCase(String jsonString){
        JsonObject jsonObject = (JsonObject) parser.parse(jsonString);
        NavigationAssistant navigator = new NavigationAssistant(jsonObject);

        assertEquals(5, jsonObject.getProperties().size());
        //first assertion: object.data.jobs.items[0].jobUrl
        navigator.reset();
        assertEquals("/is-ilani/arvato-lojistik-anonim-sirketi-senior-software-developer-3213313",
                navigator.getProperty(2).getProperty(4).getProperty(0).getElement(0).getProperty(3).asString().getValue());
        //second assertion: object.data.jobs.items[1].id
        navigator.reset();
        assertEquals(3609107D,
                navigator.getProperty(2).getProperty(4).getProperty(0).getElement(1).getProperty(0).asNumber().getValue());
        //third assertion: object.error
        navigator.reset();
        assertDoesNotThrow(() -> navigator.getProperty(4).asNull());
        //fourth assertion: object.data.jobSeo.nextPageLink
        navigator.reset();
        assertEquals("https://www.kariyer.net/is-ilanlari/ingilizce-2",
                navigator.getProperty(2).getProperty(7).getProperty(6).asString().getValue());
        //fifth assertion: object.data.jobs.items[0].sectors[0].code
        navigator.reset();
        assertEquals("016007000",
                navigator.getProperty(2).getProperty(4).getProperty(0).getElement(0).getProperty(23).getElement(0).getProperty(0).asString().getValue());

        assertEquals(0, service.report.invalidations.size());
    }

    @Test
    void erroneousComplexCase() {
        runErroneousComplexCase(SampleErroneousData.INDENTED_JSON);
        runErroneousComplexCase(SampleErroneousData.MINIFIED_JSON);
    }

    void runErroneousComplexCase(String jsonString){
        parser.parse(jsonString);

        //first error
        assertEquals(1,
                service.report.invalidations.stream().filter(
                        invalidation -> {
                            return invalidation.validator.equals(PropertyValidator.class) &&
                                    invalidation.invalidExpression.getExpressionString().equals("\"title\"\"Senior Software Developer\"");
                        }).toList().size()
        );

        //second error
        assertEquals(1,
                service.report.invalidations.stream().filter(
                        invalidation -> {
                            return invalidation.validator.equals(PropertyNameValidator.class) &&
                                    invalidation.invalidExpression.getExpressionString().equals("companyName");
                        }
                ).toList().size()
        );

        //third error
        assertEquals(1,
                service.report.invalidations.stream().filter(
                        invalidation -> {
                            return invalidation.validator.equals(JsonInvalidValidator.class) &&
                                    invalidation.invalidExpression.getExpressionString().equals("**");
                        }
                ).toList().size()
        );
    }


    static class DummyReportingService implements ReportingService{
        ExecutionReport report;

        @Override
        public void addExecutionReport(ExecutionReport report) {
            this.report = report;
        }
    }

    static class NavigationAssistant{
        final Json initial;
        Json currentJson;

        public NavigationAssistant(Json currentJson) {
            this.initial = currentJson;
            this.currentJson = currentJson;
        }

        public void reset(){
            currentJson = initial;
        }

        NavigationAssistant getProperty(int propertyIndex){
            currentJson = ((JsonObject) currentJson).getProperties().get(propertyIndex).getValue();
            return this;
        }

        NavigationAssistant getElement(int index){
            currentJson = ((JsonArray) currentJson).getArray().get(index);
            return this;
        }

        public JsonNumber asNumber(){ return (JsonNumber) currentJson;}
        public JsonString asString(){ return (JsonString) currentJson;}
        public JsonBinary asBinary(){ return (JsonBinary) currentJson;}
        public JsonNull asNull(){ return (JsonNull) currentJson;}
        public JsonInvalid asInvalid(){ return (JsonInvalid) currentJson;}
        public JsonArray asArray(){ return (JsonArray) currentJson;}
        public JsonObject asObject(){ return (JsonObject) currentJson;}
    }
}