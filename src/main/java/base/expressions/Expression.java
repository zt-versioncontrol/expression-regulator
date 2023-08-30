package base.expressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Expression {
    private final String expression;
    private Expression origin;
    private List<Expression> derivedExpressions = null;

    public Expression(String expression) {
        this.expression = normalize(expression);
        this.origin = null;
        initializeDerivedExpressions();
    }

    private void initializeDerivedExpressions(){
        List<Expression> expressionQueue = new ArrayList<>();
        expressionQueue.add(this);
        while (!expressionQueue.isEmpty()){
            Expression nextExpression = expressionQueue.remove(0);

            nextExpression.derivedExpressions = nextExpression.computeDerivedExpressions();
            if (nextExpression.derivedExpressions == null) nextExpression.derivedExpressions = new ArrayList<>();
            for (Expression derivedExpression : nextExpression.derivedExpressions) {
                derivedExpression.origin = nextExpression;
            }

            expressionQueue.addAll(nextExpression.derivedExpressions);
        }
    }

    @Override
    public String toString(){
        return expression;
    }

    public Iterator<Expression> getDerivedExpressions(){
        return derivedExpressions.iterator();
    }

    public Expression getOrigin() {
        return origin;
    }

    public Class<? extends Expression> getType(){
        return this.getClass();
    }

    protected abstract String normalize(String expression);
    protected abstract List<Expression> computeDerivedExpressions();
}
