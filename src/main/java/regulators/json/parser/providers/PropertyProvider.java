package regulators.json.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.parser.parsedObjects.Property;

public class PropertyProvider implements InstanceProvider {
    @Override
    public Property provide(String expression) {
        return new Property();
    }
}
