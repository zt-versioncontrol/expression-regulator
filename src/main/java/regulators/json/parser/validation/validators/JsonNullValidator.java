package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.JsonNullExpressionSelector;

public class JsonNullValidator extends BasicExpressionValidator {

    protected JsonNullValidator() {
        super(JsonNullExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {

        return expression.getExpressionString().equals("null");
    }
}
