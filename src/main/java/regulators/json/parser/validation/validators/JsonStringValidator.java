package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.JsonStringExpressionSelector;

public class JsonStringValidator extends BasicExpressionValidator {

    public JsonStringValidator(){
        super(JsonStringExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        return (expressionString.charAt(0) == '"' && expressionString.charAt(expressionString.length()-1) == '"') ||
                (expressionString.charAt(0) == '\'' && expressionString.charAt(expressionString.length()-1) == '\'');
    }
}
