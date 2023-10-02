package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.parsing.ExtractorType;

public abstract class ByExtractorExtractorOfOriginAndHasDerivedByExtractor implements SimpleExpressionSelector{
    private final Class<? extends ExtractorType> extractor;
    private final Class<? extends ExtractorType> extractorOfOrigin;
    private final Class<? extends ExtractorType> extractorOfDerived;

    protected ByExtractorExtractorOfOriginAndHasDerivedByExtractor(Class<? extends ExtractorType> extractor, Class<? extends ExtractorType> extractorOfOrigin, Class<? extends ExtractorType> extractorOfDerived) {
        this.extractor = extractor;
        this.extractorOfOrigin = extractorOfOrigin;
        this.extractorOfDerived = extractorOfDerived;
    }

    @Override
    public boolean isSelected(Expression expression) {
        if (expression.getOriginalExpression() == null) return false;

        if (extractor.equals(expression.getExtractorClass()) &&
                extractorOfOrigin.equals(expression.getOriginalExpression().getExtractorClass())){
            for (Expression derivedExpression : expression.getDerivedExpressions()) {
                if (extractorOfDerived.equals(derivedExpression.getExtractorClass())) return true;
            }
        }

        return false;
    }
}
