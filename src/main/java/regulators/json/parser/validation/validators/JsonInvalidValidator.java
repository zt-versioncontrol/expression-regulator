package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.JsonInvalidExpressionSelector;

public class JsonInvalidValidator extends BasicExpressionValidator {
    protected JsonInvalidValidator() {
        super(JsonInvalidExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return false;
    }
}
