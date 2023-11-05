package regulators.java.parser.validation.validators.structureValidators.logic;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByExtractorSelectors;

public class StatementValidator extends BasicExpressionValidator {

    protected StatementValidator() {
        super(ByExtractorSelectors.StatementSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().endsWith(";");
    }
}
