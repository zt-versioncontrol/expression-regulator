package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.RangeSelector;

public class RangeValidator extends BasicExpressionValidator {
    protected RangeValidator() {
        super(RangeSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().contains(":");
    }
}
