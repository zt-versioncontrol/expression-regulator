package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.PropertyExpressionSelector;

public class PropertyValidator extends BasicExpressionValidator {

    public PropertyValidator(){
        super(PropertyExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        return expressionString.contains(":");
    }
}
