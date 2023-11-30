package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.PathSelector;

public class PathValidator extends BasicExpressionValidator {
    protected PathValidator() {
        super(PathSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().startsWith("{") && expression.getExpressionString().endsWith("}");
    }
}
