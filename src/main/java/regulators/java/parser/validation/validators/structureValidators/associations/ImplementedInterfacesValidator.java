package regulators.java.parser.validation.validators.structureValidators.associations;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.ImplementedInterfacesSelector;

public class ImplementedInterfacesValidator extends BasicExpressionValidator {

    protected ImplementedInterfacesValidator() {
        super(ImplementedInterfacesSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        if (expressionString.isEmpty()) return true;
        return expressionString.startsWith("implements ") && !expressionString.substring("implements ".length()).isBlank();
    }
}
