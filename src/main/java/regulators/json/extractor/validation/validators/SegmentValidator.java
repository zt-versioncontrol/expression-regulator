package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.SegmentSelector;

public class SegmentValidator extends BasicExpressionValidator {
    protected SegmentValidator() {
        super(SegmentSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().contains("=");
    }
}
