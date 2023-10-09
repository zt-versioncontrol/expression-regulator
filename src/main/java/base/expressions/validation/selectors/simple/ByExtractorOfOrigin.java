package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.components.expression.parsing.ExtractorType;

public abstract class ByExtractorOfOrigin implements BasicExpressionSelector {
    private final Class<? extends ExtractorType> extractorClass;

    public ByExtractorOfOrigin(Class<? extends ExtractorType> extractorClass) {
        this.extractorClass = extractorClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        return Utilities.extractorOfOriginMatches(expression, extractorClass);
    }

    public static abstract class WithMatcher extends ByExtractorOfOrigin{
        private final StringMatcher stringMatcher;

        public WithMatcher(Class<? extends ExtractorType> extractorClass, StringMatcher stringMatcher) {
            super(extractorClass);
            this.stringMatcher = stringMatcher;
        }

        @Override
        public boolean isSelected(Expression expression) {
            return super.isSelected(expression) && Utilities.originalExpressionMatches(expression, stringMatcher);
        }
    }
}
