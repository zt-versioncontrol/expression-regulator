package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.attributes.ClassGenerics;

public class GenericsProvider implements InstanceProvider {
    @Override
    public ClassGenerics provide(String expression) {
        if (expression.isEmpty()) return null;

        return new ClassGenerics();
    }
}
