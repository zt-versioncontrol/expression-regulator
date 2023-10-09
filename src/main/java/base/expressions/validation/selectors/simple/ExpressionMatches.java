package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;

public abstract class ExpressionMatches implements BasicExpressionSelector {
    private final StringMatcher stringMatcher;
    private final StringMatcher originStringMatcher;
    private final StringMatcher derivedStringMatcher;

    protected ExpressionMatches(StringMatcher stringMatcher, StringMatcher originStringMatcher, StringMatcher derivedStringMatcher) {
        this.stringMatcher = stringMatcher;
        this.originStringMatcher = originStringMatcher;
        this.derivedStringMatcher = derivedStringMatcher;
    }

    @Override
    public boolean isSelected(Expression expression) {
        return Utilities.expressionMatches(expression, stringMatcher) &&
                Utilities.originalExpressionMatches(expression, originStringMatcher) &&
                Utilities.anyDerivedExpressionMatches(expression, derivedStringMatcher);
    }


}
