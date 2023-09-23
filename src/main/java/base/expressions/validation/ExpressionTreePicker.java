package base.expressions.validation;

import base.expressions.Expression;

import java.util.List;

public interface ExpressionTreePicker {
    List<Expression> pick(Expression root);
}
