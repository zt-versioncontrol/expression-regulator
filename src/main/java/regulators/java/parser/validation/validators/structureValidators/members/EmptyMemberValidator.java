package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectos;

public class EmptyMemberValidator extends BasicExpressionValidator {
    protected EmptyMemberValidator() {
        super(ByConcreteTypeSelectos.EmptyMemberSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().equals(";");
    }
}
