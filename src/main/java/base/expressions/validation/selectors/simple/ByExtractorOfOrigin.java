package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.parsing.ExtractorType;

public abstract class ByExtractorOfOrigin implements SimpleExpressionSelector {
    private final Class<? extends ExtractorType> extractorClass;

    public ByExtractorOfOrigin(Class<? extends ExtractorType> extractorClass) {
        this.extractorClass = extractorClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        if (expression.getOriginalExpression() == null) return false;

        return extractorClass.equals(expression.getOriginalExpression().getExtractorClass());
    }
}
