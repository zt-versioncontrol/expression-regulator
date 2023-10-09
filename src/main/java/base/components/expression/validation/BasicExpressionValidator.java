package base.components.expression.validation;

import base.components.expression.ExpressionComponent;
import base.expressions.Expression;

public abstract class BasicExpressionValidator implements ExpressionComponent {
    public final Class<? extends BasicExpressionSelector> selectorClass;

    protected BasicExpressionValidator(Class<? extends BasicExpressionSelector> selectorClass) {
        this.selectorClass = selectorClass;
    }

    public abstract boolean validate(Expression expression);
}
