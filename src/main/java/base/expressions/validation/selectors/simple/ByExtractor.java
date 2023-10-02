package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.parsing.ExtractorType;

public abstract class ByExtractor implements SimpleExpressionSelector {
    private final Class<? extends ExtractorType> extractorClass;

    protected ByExtractor(Class<? extends ExtractorType> extractorClass) {
        this.extractorClass = extractorClass;
    }


    @Override
    public boolean isSelected(Expression expression) {
        return extractorClass.equals(expression.getExtractorClass());
    }
}
