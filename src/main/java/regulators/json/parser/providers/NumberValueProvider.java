package regulators.json.parser.providers;

import base.components.expression.parsing.InstanceProvider;

public class NumberValueProvider implements InstanceProvider {
    @Override
    public Double provide(String expression) {
        return Double.parseDouble(expression);
    }
}
