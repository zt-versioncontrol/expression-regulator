package regulators.json.parser.providers;

import base.components.expression.parsing.InstanceProvider;

public class BinaryValueProvider implements InstanceProvider {
    @Override
    public Boolean provide(String expression) {
        return expression.equals("true");
    }
}
