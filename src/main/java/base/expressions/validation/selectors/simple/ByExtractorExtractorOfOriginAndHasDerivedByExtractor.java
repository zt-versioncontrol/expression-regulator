package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.components.expression.parsing.ExtractorType;

public abstract class ByExtractorExtractorOfOriginAndHasDerivedByExtractor implements BasicExpressionSelector {
    private final Class<? extends ExtractorType> extractor;
    private final Class<? extends ExtractorType> extractorOfOrigin;
    protected final Class<? extends ExtractorType> extractorOfDerived;

    protected ByExtractorExtractorOfOriginAndHasDerivedByExtractor(Class<? extends ExtractorType> extractor, Class<? extends ExtractorType> extractorOfOrigin, Class<? extends ExtractorType> extractorOfDerived) {
        this.extractor = extractor;
        this.extractorOfOrigin = extractorOfOrigin;
        this.extractorOfDerived = extractorOfDerived;
    }

    @Override
    public boolean isSelected(Expression expression) {
        return Utilities.extractorMatches(expression, extractor) &&
                Utilities.extractorOfOriginMatches(expression, extractorOfOrigin) &&
                Utilities.extractorOfDerivedPresent(expression, extractorOfDerived);
    }

    public static abstract class WithMatcher extends ByExtractorExtractorOfOriginAndHasDerivedByExtractor{
        private final StringMatcher stringMatcher;
        private final StringMatcher originalStringMatcher;
        private final StringMatcher derivedStringMatcher;


        protected WithMatcher(Class<? extends ExtractorType> extractor,
                              Class<? extends ExtractorType> extractorOfOrigin,
                              Class<? extends ExtractorType> extractorOfDerived,
                              StringMatcher stringMatcher,
                              StringMatcher originalStringMatcher,
                              StringMatcher derivedStringMatcher)
        {
            super(extractor, extractorOfOrigin, extractorOfDerived);
            this.stringMatcher = stringMatcher;
            this.originalStringMatcher = originalStringMatcher;
            this.derivedStringMatcher = derivedStringMatcher;
        }

        @Override
        public boolean isSelected(Expression expression) {
            return super.isSelected(expression) &&
                    Utilities.expressionMatches(expression, stringMatcher) &&
                    Utilities.originalExpressionMatches(expression, originalStringMatcher) &&
                    Utilities.extractorOfDerivedPresentAndItsExpressionMatches(expression, extractorOfDerived, derivedStringMatcher);
        }
    }
}
