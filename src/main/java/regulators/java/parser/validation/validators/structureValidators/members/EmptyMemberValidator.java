package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectors;

public class EmptyMemberValidator extends BasicExpressionValidator {
    protected EmptyMemberValidator() {
        super(ByConcreteTypeSelectors.EmptyMemberSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().equals(";");
    }
}
