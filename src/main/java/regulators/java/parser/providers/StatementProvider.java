package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.logic.Statement;

public class StatementProvider implements InstanceProvider {
    @Override
    public Statement provide(String expression) {
        return new Statement(expression);
    }
}
