package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.components.expression.parsing.ExtractorType;

public abstract class ByExtractorOfOriginAndHasDerivedByExtractor implements BasicExpressionSelector {
    private final Class<? extends ExtractorType> originExtractorClass;
    protected final Class<? extends ExtractorType> derivedExtractorClass;

    protected ByExtractorOfOriginAndHasDerivedByExtractor(Class<? extends ExtractorType> originExtractorClass, Class<? extends ExtractorType> derivedExtractorClass) {
        this.originExtractorClass = originExtractorClass;
        this.derivedExtractorClass = derivedExtractorClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        return Utilities.extractorOfOriginMatches(expression, originExtractorClass) &&
                Utilities.extractorOfDerivedPresent(expression, derivedExtractorClass);
    }

    public static abstract class WithMatcher extends ByExtractorOfOriginAndHasDerivedByExtractor{
        private final StringMatcher originStringMatcher;
        private final StringMatcher derivedStringMatcher;

        protected WithMatcher(Class<? extends ExtractorType> originExtractorClass,
                              Class<? extends ExtractorType> derivedExtractorClass,
                              StringMatcher originStringMatcher,
                              StringMatcher derivedStringMatcher)
        {
            super(originExtractorClass, derivedExtractorClass);
            this.originStringMatcher = originStringMatcher;
            this.derivedStringMatcher = derivedStringMatcher;
        }

        @Override
        public boolean isSelected(Expression expression) {
            return super.isSelected(expression) &&
                    Utilities.originalExpressionMatches(expression, originStringMatcher) &&
                    Utilities.extractorOfDerivedPresentAndItsExpressionMatches(expression, derivedExtractorClass, derivedStringMatcher);
        }
    }
}
