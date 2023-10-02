package base.expressions.validation;

import base.expressions.Expression;
import base.expressions.validation.selectors.simple.SimpleExpressionSelector;

public abstract class BasicExpressionValidator {
    private final Class<? extends SimpleExpressionSelector> selectorClass;

    protected BasicExpressionValidator(Class<? extends SimpleExpressionSelector> selectorClass) {
        this.selectorClass = selectorClass;
    }

    public abstract boolean validate(Expression expression);
}
