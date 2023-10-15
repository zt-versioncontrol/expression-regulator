package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.JsonObjectExpressionSelector;

public class JsonObjectValidator extends BasicExpressionValidator {

    public JsonObjectValidator(){
        super(JsonObjectExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        if (expressionString.length() < 2) return false;
        return expressionString.charAt(0) == '{' && expressionString.charAt(expressionString.length()-1) == '}';
    }
}
