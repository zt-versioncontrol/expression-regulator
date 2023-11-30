package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.ExtractionSelector;

public class ExtractionValidator extends BasicExpressionValidator {
    protected ExtractionValidator() {
        super(ExtractionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().contains(">") &&
                !expression.getExpressionString().contains("<") &&
                !expression.getExpressionString().contains("=");
    }
}
