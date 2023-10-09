package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.components.expression.parsing.ExtractorType;

public abstract class ByExtractorAndExtractorOfOrigin implements BasicExpressionSelector {
    private final Class<? extends ExtractorType> extractorClass;
    private final Class<? extends ExtractorType> originExtractorClass;

    protected ByExtractorAndExtractorOfOrigin(Class<? extends ExtractorType> extractorClass, Class<? extends ExtractorType> originExtractorClass) {
        this.extractorClass = extractorClass;
        this.originExtractorClass = originExtractorClass;
    }

    @Override
    public boolean isSelected(Expression expression) {
        return Utilities.extractorMatches(expression, extractorClass) &&
                Utilities.extractorOfOriginMatches(expression, originExtractorClass);
    }

    public static abstract class WithMatcher extends ByExtractorAndExtractorOfOrigin{
        private final StringMatcher stringMatcher;
        private final StringMatcher originStringMatcher;

        protected WithMatcher(Class<? extends ExtractorType> extractorClass,
                              Class<? extends ExtractorType> originExtractorClass,
                              StringMatcher stringMatcher,
                              StringMatcher originStringMatcher)
        {
            super(extractorClass, originExtractorClass);
            this.stringMatcher = stringMatcher;
            this.originStringMatcher = originStringMatcher;
        }

        @Override
        public boolean isSelected(Expression expression) {
            return super.isSelected(expression) &&
                    Utilities.expressionMatches(expression, stringMatcher) &&
                    Utilities.originalExpressionMatches(expression, originStringMatcher);
        }
    }
}
