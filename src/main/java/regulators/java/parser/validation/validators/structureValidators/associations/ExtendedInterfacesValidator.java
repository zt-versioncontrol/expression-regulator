package regulators.java.parser.validation.validators.structureValidators.associations;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByExtractorSelectors;

public class ExtendedInterfacesValidator extends BasicExpressionValidator {


    protected ExtendedInterfacesValidator() {
        super(ByExtractorSelectors.ExtendedInterfacesSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        if (expressionString.isEmpty()) return true;
        return expressionString.startsWith("extends ") && !expressionString.substring("extends ".length()).isBlank();
    }
}
