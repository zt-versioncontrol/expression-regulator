package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectos;

public class InitializationBlockValidator extends BasicExpressionValidator {

    protected InitializationBlockValidator() {
        super(ByConcreteTypeSelectos.InitializationBlockSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().startsWith("{") && expression.getExpressionString().endsWith("}");
    }
}
