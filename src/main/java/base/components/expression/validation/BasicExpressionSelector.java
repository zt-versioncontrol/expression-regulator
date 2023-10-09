package base.components.expression.validation;

import base.components.expression.ExpressionComponent;
import base.expressions.Expression;

public interface BasicExpressionSelector extends ExpressionComponent {
    boolean isSelected(Expression expression);
}
