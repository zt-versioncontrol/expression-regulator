package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.TypeMemberSelector;

public class TypeMemberValidator extends BasicExpressionValidator {


    protected TypeMemberValidator() {
        super(TypeMemberSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().endsWith(";") || expression.getExpressionString().endsWith("}");
    }
}
