package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.ArraySelector;

public class ArrayValidator extends BasicExpressionValidator {
    protected ArrayValidator() {
        super(ArraySelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().startsWith("[") && expression.getExpressionString().endsWith("]");
    }
}
