package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.components.expression.parsing.ExtractorType;


public abstract class HasDerivedByExtractor implements BasicExpressionSelector {
    protected final Class<? extends ExtractorType> extractorClass;

    protected HasDerivedByExtractor(Class<? extends ExtractorType> extractorClass) {
        this.extractorClass = extractorClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        return Utilities.extractorOfDerivedPresent(expression, extractorClass);
    }

    public static abstract class WithMatcher extends HasDerivedByExtractor{
        private final StringMatcher stringMatcher;

        protected WithMatcher(Class<? extends ExtractorType> extractorClass, StringMatcher stringMatcher) {
            super(extractorClass);
            this.stringMatcher = stringMatcher;
        }

        @Override
        public boolean isSelected(Expression expression) {
            return super.isSelected(expression) &&
                    Utilities.extractorOfDerivedPresentAndItsExpressionMatches(expression, extractorClass, stringMatcher);
        }
    }
}
