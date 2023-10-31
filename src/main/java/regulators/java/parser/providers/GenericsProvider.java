package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.members.Generics;

public class GenericsProvider implements InstanceProvider {
    @Override
    public Generics provide(String expression) {
        if (expression.isEmpty()) return null;

        return new Generics();
    }
}
