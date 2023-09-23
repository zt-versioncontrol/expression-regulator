package base.expressions.validation;

import base.expressions.Expression;

public interface ExpressionValidator {
    ExpressionTreePicker getExpressionPicker();
    void validate(Expression expression);
}
