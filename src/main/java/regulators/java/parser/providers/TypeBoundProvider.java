package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.associations.TypeSelector;

public class TypeBoundProvider implements InstanceProvider {
    @Override
    public TypeSelector provide(String expression) {
        if (expression.isEmpty()) return null;
        return new TypeSelector();
    }
}
