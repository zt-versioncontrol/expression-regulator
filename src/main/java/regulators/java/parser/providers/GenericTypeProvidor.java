package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.attributes.GenericType;

public class GenericTypeProvidor implements InstanceProvider {
    @Override
    public GenericType provide(String expression) {
        return new GenericType();
    }
}
