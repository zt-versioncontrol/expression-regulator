package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.components.expression.parsing.ExtractorType;

class Utilities {
    private Utilities() {
    }

    public static boolean extractorMatches(Expression expression, Class<? extends ExtractorType> extractorClass){
        if (extractorClass == null) return false;
        return extractorClass.equals(expression.getExtractorClass());
    }

    public static boolean extractorOfOriginMatches(Expression expression, Class<? extends ExtractorType> extractorClass){
        if (extractorClass == null) return false;
        if (expression.getOriginalExpression() == null) return false;

        return extractorClass.equals(expression.getOriginalExpression().getExtractorClass());
    }

    public static boolean extractorOfDerivedPresent(Expression expression, Class<? extends ExtractorType> extractorClass){
        if (extractorClass == null) return false;
        for (Expression derivedExpression : expression.getDerivedExpressions()) {
            if (extractorClass.equals(derivedExpression.getExtractorClass())) return true;
        }

        return false;
    }

    public static boolean expressionMatches(Expression expression, StringMatcher matcher){
        return matcher.match(expression.getExpressionString());
    }

    public static boolean originalExpressionMatches(Expression expression, StringMatcher matcher){
        return matcher.match(expression.getOriginalExpression().getExpressionString());
    }

    public static boolean anyDerivedExpressionMatches(Expression expression, StringMatcher matcher){
        for (Expression derivedExpression : expression.getDerivedExpressions()) {
            if (matcher.match(derivedExpression.getExpressionString())) return true;
        }

        return false;
    }

    public static boolean extractorOfDerivedPresentAndItsExpressionMatches(Expression expression,
                                                                           Class<? extends ExtractorType> extractorClass,
                                                                           StringMatcher matcher)
    {
        for (Expression derivedExpression : expression.getDerivedExpressions()) {
            if (extractorClass.equals(derivedExpression.getExtractorClass()) &&
                    matcher.match(derivedExpression.getExpressionString()))
            {
                return true;
            }
        }

        return false;
    }
}
