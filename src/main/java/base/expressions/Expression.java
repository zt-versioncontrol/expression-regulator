package base.expressions;

import base.parsing.ExtractorType;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private Expression originalExpression;
    private final String expressionString;
    private final Class<? extends ExtractorType> extractorClass;
    private final List<Expression> derivedExpressions = new ArrayList<>();


    public Expression(String expressionString, Class<? extends ExtractorType> extractorClass) {
        this.originalExpression = null;
        this.expressionString = expressionString;
        this.extractorClass = extractorClass;
    }


    public void addDerivedExpression(Expression derivedExpression) throws ExpressionAlreadyHasOrigin{
        if (derivedExpression.originalExpression != null) throw new ExpressionAlreadyHasOrigin();
        derivedExpression.originalExpression = this;
        derivedExpressions.add(derivedExpression);
    }

    public Expression getOriginalExpression() {
        return originalExpression;
    }

    public String getExpressionString() {
        return expressionString;
    }

    public Class<? extends ExtractorType> getExtractorClass() {
        return extractorClass;
    }

    public Iterable<Expression> getDerivedExpressions() {
        return derivedExpressions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Expression otherExpression){
            if(originalExpression == null){
                if (otherExpression.originalExpression != null) return false;
            } else if(!originalExpression.equals(otherExpression.originalExpression)) return false;

            if (expressionString == null) return false;
            else if(!expressionString.equals(otherExpression.expressionString)) return false;

            if (extractorClass == null){
                if(otherExpression.extractorClass != null) return false;
            } else if(!extractorClass.equals(otherExpression.extractorClass)) return false;

            return derivedExpressionsEquals(otherExpression);
        }

        return false;
    }

    private boolean derivedExpressionsEquals(Expression otherExpression){
        if (derivedExpressions.size() != otherExpression.derivedExpressions.size()) return false;

        for (int i = 0; i < derivedExpressions.size(); i++) {
            Expression derivedExpression = derivedExpressions.get(i);
            Expression otherDerivedExpression = otherExpression.derivedExpressions.get(i);

            if (derivedExpression.expressionString == null) return false;
            else if(!derivedExpression.expressionString.equals(otherDerivedExpression.expressionString)) return false;

            if (derivedExpression.extractorClass == null){
                if (otherDerivedExpression.extractorClass != null) return false;
            } else if(!derivedExpression.extractorClass.equals(otherDerivedExpression.extractorClass)) return false;

            if(!derivedExpression.derivedExpressionsEquals(otherDerivedExpression)) return false;
        }

        return true;
    }

    public static class ExpressionAlreadyHasOrigin extends RuntimeException{};
}
