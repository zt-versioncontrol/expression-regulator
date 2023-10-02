package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.parsing.ExtractorType;


public abstract class HasDerivedByExtractor implements SimpleExpressionSelector {
    private final Class<? extends ExtractorType> extractorClass;

    protected HasDerivedByExtractor(Class<? extends ExtractorType> extractorClass) {
        this.extractorClass = extractorClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        for (Expression derivedExpression : expression.getDerivedExpressions()) {
            if (extractorClass.equals(derivedExpression.getExtractorClass())) return true;
        }

        return false;
    }
}
