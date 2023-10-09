package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.BinaryExpressionSelector;

public class JsonBinaryValidator extends BasicExpressionValidator {
    protected JsonBinaryValidator() {
        super(BinaryExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressioString = expression.getExpressionString();

        return expressioString.equalsIgnoreCase("true") || expressioString.equalsIgnoreCase("false");
    }
}
