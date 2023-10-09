package base.components.expression.parsing;

import base.components.expression.ExpressionComponent;

public interface InstanceProvider extends ExpressionComponent {
    Object provide(String expression);
}
