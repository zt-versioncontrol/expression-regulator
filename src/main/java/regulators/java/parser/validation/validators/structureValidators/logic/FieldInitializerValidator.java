package regulators.java.parser.validation.validators.structureValidators.logic;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByExtractorSelectors;

public class FieldInitializerValidator extends BasicExpressionValidator {

    protected FieldInitializerValidator() {
        super(ByExtractorSelectors.FieldInitializerSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        if (expression.getExpressionString().isBlank()) return true;
        return expression.getExpressionString().endsWith(";");
    }
}
