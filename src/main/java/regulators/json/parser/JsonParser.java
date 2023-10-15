package regulators.json.parser;

import base.components.expression.ExpressionComponent;
import base.components.expression.ExpressionComponentsInitializer;
import base.drivers.parsing.ParsingDriver;
import base.drivers.parsing.ReportingService;
import regulators.json.parser.extractors.Extractorsinitializer;
import regulators.json.parser.parsedObjects.Json;
import regulators.json.parser.parsedObjects.JsonRoot;
import regulators.json.parser.providers.ProvidersInitializer;
import regulators.json.parser.validation.selectors.SelectorsInitializer;
import regulators.json.parser.validation.validators.ValidatorsInitializer;

import java.util.HashSet;
import java.util.Set;

public class JsonParser extends ParsingDriver<JsonRoot> {

    protected JsonParser() {
        super(new ComponentsInitializer());
    }

    protected JsonParser(ReportingService reportingService) {
        super(new ComponentsInitializer(), reportingService);
    }

    public Json parse(String jsonExpression){
        JsonRoot jsonRoot = new JsonRoot();
        execute(jsonRoot, jsonExpression);


        return jsonRoot.getJson();
    }


    private static class ComponentsInitializer implements ExpressionComponentsInitializer{

        @Override
        public Set<ExpressionComponent> initialize() {
            Set<ExpressionComponent> components = new HashSet<>();
            components.addAll(new Extractorsinitializer().provide());
            components.addAll(new ProvidersInitializer().provide());
            components.addAll(new SelectorsInitializer().provide());
            components.addAll(new ValidatorsInitializer().provide());
            return components;
        }
    }
}
