package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.StatementSelector;

public class StatementValidator extends BasicExpressionValidator {
    protected StatementValidator() {
        super(StatementSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().endsWith(";");
    }
}
