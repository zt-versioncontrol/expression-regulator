package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.attributes.SuperClass;

public class SuperClassProvider implements InstanceProvider {
    @Override
    public SuperClass provide(String expression) {
        if (expression.isEmpty()) return null;
        return new SuperClass();
    }
}
