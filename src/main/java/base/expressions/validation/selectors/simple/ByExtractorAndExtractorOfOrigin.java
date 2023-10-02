package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.parsing.ExtractorType;

public abstract class ByExtractorAndExtractorOfOrigin implements SimpleExpressionSelector {
    private final Class<? extends ExtractorType> extractorClass;
    private final Class<? extends ExtractorType> originExtractorClass;

    protected ByExtractorAndExtractorOfOrigin(Class<? extends ExtractorType> extractorClass, Class<? extends ExtractorType> originExtractorClass) {
        this.extractorClass = extractorClass;
        this.originExtractorClass = originExtractorClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        if (expression.getOriginalExpression() == null) return false;

        return extractorClass.equals(expression.getExtractorClass()) &&
                originExtractorClass.equals(expression.getOriginalExpression().getExtractorClass());
    }
}
