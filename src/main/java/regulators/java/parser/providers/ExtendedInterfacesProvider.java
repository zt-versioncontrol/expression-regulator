package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.attributes.ExtendedInterfaces;

public class ExtendedInterfacesProvider implements InstanceProvider {
    @Override
    public ExtendedInterfaces provide(String expression) {
        if (expression.isBlank()) return null;
        return new ExtendedInterfaces();
    }
}
