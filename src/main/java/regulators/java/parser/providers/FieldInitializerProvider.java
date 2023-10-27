package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;

public class FieldInitializerProvider implements InstanceProvider {
    @Override
    public String provide(String expression) {
        if (expression.isBlank()) return null;
        return expression;
    }
}
