package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.RangeBoundSelector;

public class RangeBoundValidator extends BasicExpressionValidator {
    protected RangeBoundValidator() {
        super(RangeBoundSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        if (expression.getExpressionString().isBlank()) return true;

        try {
            Integer.parseInt(expression.getExpressionString());
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
