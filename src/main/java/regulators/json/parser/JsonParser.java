package regulators.json.parser;

import base.components.expression.ExpressionComponent;
import base.components.expression.ExpressionComponentsInitializer;
import regulators.json.parser.extractors.Extractorsinitializer;
import regulators.json.parser.parsedObjects.Json;
import regulators.json.parser.parsedObjects.JsonRoot;
import regulators.json.parser.providers.ProvidersInitializer;
import regulators.json.parser.validation.selectors.SelectorsInitializer;
import regulators.json.parser.validation.validators.ValidatorsInitializer;

import java.util.HashSet;
import java.util.Set;

public class JsonParser {

    public Json Parse(String jsonExpression){
        JsonRoot jsonRoot = new JsonRoot();


        return null;
    }


    private static class componentsInitializer implements ExpressionComponentsInitializer{

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
