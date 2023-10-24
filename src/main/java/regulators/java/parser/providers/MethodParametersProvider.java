package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.members.MethodParameter;

public class MethodParametersProvider implements InstanceProvider {
    @Override
    public MethodParameter provide(String expression) {
        return new MethodParameter();
    }
}
