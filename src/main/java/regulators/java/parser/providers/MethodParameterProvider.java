package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.members.MethodParameter;

public class MethodParameterProvider implements InstanceProvider {
    @Override
    public MethodParameter provide(String expression) {
        return new MethodParameter();
    }
}
