package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.components.expression.parsing.ExtractorType;

public abstract class ByExtractorAndHasDerivedByExtractor implements BasicExpressionSelector {
    private final Class<? extends ExtractorType> extractorClass;
    protected final Class<? extends ExtractorType> extractorOfDerivedClass;

    public ByExtractorAndHasDerivedByExtractor(Class<? extends ExtractorType> extractorClass, Class<? extends ExtractorType> extractorOfDerivedClass) {
        this.extractorClass = extractorClass;
        this.extractorOfDerivedClass = extractorOfDerivedClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        return Utilities.extractorMatches(expression, extractorClass) &&
                Utilities.extractorOfDerivedPresent(expression, extractorOfDerivedClass);
    }

    public static abstract class WithMatcher extends ByExtractorAndHasDerivedByExtractor{
        private final StringMatcher stringMatcher;
        private final StringMatcher derivedStringMatcher;

        public WithMatcher(Class<? extends ExtractorType> extractorClass,
                           Class<? extends ExtractorType> extractorOfDerivedClass,
                           StringMatcher stringMatcher,
                           StringMatcher derivedStringMatcher)
        {
            super(extractorClass, extractorOfDerivedClass);
            this.stringMatcher = stringMatcher;
            this.derivedStringMatcher = derivedStringMatcher;
        }

        @Override
        public boolean isSelected(Expression expression) {
            return super.isSelected(expression) &&
                    Utilities.expressionMatches(expression, stringMatcher) &&
                    Utilities.extractorOfDerivedPresentAndItsExpressionMatches(expression, extractorOfDerivedClass, derivedStringMatcher);
        }
    }
}
