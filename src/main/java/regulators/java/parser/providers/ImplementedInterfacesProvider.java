package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.attributes.ImplementedInterfaces;

public class ImplementedInterfacesProvider implements InstanceProvider {
    @Override
    public ImplementedInterfaces provide(String expression) {
        if (expression.isEmpty())return null;
        return new ImplementedInterfaces();
    }
}
