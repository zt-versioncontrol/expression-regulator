package regulators.json.parser.providers;

import base.parsing.InstanceProvider;

public class JsonNumberProvider implements InstanceProvider {
    @Override
    public Object provide(String expression) {
        return Double.parseDouble(expression);
    }
}
