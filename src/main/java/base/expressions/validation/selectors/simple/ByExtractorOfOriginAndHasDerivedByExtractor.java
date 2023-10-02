package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.parsing.ExtractorType;

public abstract class ByExtractorOfOriginAndHasDerivedByExtractor implements SimpleExpressionSelector {
    private final Class<? extends ExtractorType> originExtractorClass;
    private final Class<? extends ExtractorType> derivedExtractorClass;

    protected ByExtractorOfOriginAndHasDerivedByExtractor(Class<? extends ExtractorType> originExtractorClass, Class<? extends ExtractorType> derivedExtractorClass) {
        this.originExtractorClass = originExtractorClass;
        this.derivedExtractorClass = derivedExtractorClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        if (expression.getOriginalExpression() == null) return false;

        if (originExtractorClass.equals(expression.getOriginalExpression().getExtractorClass())) {
            for (Expression derivedExpression : expression.getDerivedExpressions()) {
                if (derivedExtractorClass.equals(derivedExpression.getExtractorClass())) return true;
            }
        }

        return false;
    }
}
