package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.parsing.ExtractorType;

public abstract class ByExtractorAndHasDerivedByExtractor implements SimpleExpressionSelector {
    private final Class<? extends ExtractorType> exctracterClass;
    private final Class<? extends ExtractorType> extractorOfDerivedClass;

    public ByExtractorAndHasDerivedByExtractor(Class<? extends ExtractorType> exctracterClass, Class<? extends ExtractorType> extractorOfDerivedClass) {
        this.exctracterClass = exctracterClass;
        this.extractorOfDerivedClass = extractorOfDerivedClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        if (exctracterClass.equals(expression.getExtractorClass())){
            for (Expression derivedExpression : expression.getDerivedExpressions()) {
                if (extractorOfDerivedClass.equals(derivedExpression.getExtractorClass())) return true;
            }
        }

        return false;
    }
}
