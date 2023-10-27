package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.attributes.TypeSelector;

public class GenericTypeSelectorProvider implements InstanceProvider {
    @Override
    public TypeSelector provide(String expression) {
        return new TypeSelector();
    }
}
