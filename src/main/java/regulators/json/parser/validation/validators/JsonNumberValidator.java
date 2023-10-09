package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.NumberExpressionSelector;

public class JsonNumberValidator extends BasicExpressionValidator {

    public JsonNumberValidator(){
        super(NumberExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        try {
            Double.parseDouble(expression.getExpressionString());
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
