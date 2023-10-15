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
        String expressionString = expression.getExpressionString();

        return expressionString.equals("true") || expressionString.equals("false");
    }
}
