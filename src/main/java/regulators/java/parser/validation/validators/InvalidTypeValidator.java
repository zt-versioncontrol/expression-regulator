package regulators.java.parser.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectos;

public class InvalidTypeValidator extends BasicExpressionValidator {


    protected InvalidTypeValidator() {
        super(ByConcreteTypeSelectos.InvalidTypeSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return false;
    }
}
