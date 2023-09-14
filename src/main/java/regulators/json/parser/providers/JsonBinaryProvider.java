package regulators.json.parser.providers;

import base.parsing.InstanceProvider;

public class JsonBinaryProvider implements InstanceProvider {
    @Override
    public Object provide(String expression) {
        return expression.equalsIgnoreCase("true");
    }
}
