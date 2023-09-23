package base.expressions;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final Expression originalExpression;
    private final String expressionString;
    private final String extractorName;
    private final List<Expression> derivedExpressions = new ArrayList<>();


    public Expression(Expression originalExpression, String expressionString, String extractorName) {
        this.originalExpression = originalExpression;
        this.expressionString = expressionString;
        this.extractorName = extractorName;
    }

    public void addDerivedExpression(Expression derivedExpression){
        derivedExpressions.add(derivedExpression);
    }


    public Expression getOriginalExpression() {
        return originalExpression;
    }

    public String getExpressionString() {
        return expressionString;
    }

    public String getExtractorName() {
        return extractorName;
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

            if (extractorName == null){
                if(otherExpression.extractorName != null) return false;
            } else if(!extractorName.equals(otherExpression.extractorName)) return false;

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

            if (derivedExpression.extractorName == null){
                if (otherDerivedExpression.extractorName != null) return false;
            } else if(!derivedExpression.extractorName.equals(otherDerivedExpression.extractorName)) return false;

            if(!derivedExpression.derivedExpressionsEquals(otherDerivedExpression)) return false;
        }

        return true;
    }
}
