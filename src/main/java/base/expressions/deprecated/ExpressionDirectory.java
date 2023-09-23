package base.expressions.deprecated;

import utility.ReusableIterator;
import utility.Revertible;

@Deprecated
public class ExpressionDirectory {

    private static class DirectoryState {
        Expression expression;
        ReusableIterator<Expression> derivedExpressionIterator;

        public DirectoryState(Expression expression) {
            this.expression = expression;
            derivedExpressionIterator = new ReusableIterator<>(expression.getDerivedExpressions());
        }
    }


    private final Revertible<DirectoryState> state;

    public ExpressionDirectory(Expression root) {
        this.state = new Revertible<>(() -> new DirectoryState(root));
    }

    public void back(){
        state.revert();
    }

    public void reset(){
        state.reset();
    }

    public boolean nextDerivedExpression(){
        return state.get().derivedExpressionIterator.next();
    }

    public void resetDerivedExpressionIterator(){
        state.get().derivedExpressionIterator.reset();
    }


    public void filterDerivedExpressionIterator(Class<? extends Expression> derivedExpressionType){
        state.get().derivedExpressionIterator.resetAndFilter(expression -> expression.getClass().equals(derivedExpressionType));
    }

    public void filterRemainingDerivedExpressionIterator(Class<? extends Expression> derivedExpressionType){
        state.get().derivedExpressionIterator.filterRemaining(expression -> expression.getClass().equals(derivedExpressionType));
    }

    public void moveToIteratedExpression(){
        Expression selectedDerivedExpression = state.get().derivedExpressionIterator.getIterated();
        if (selectedDerivedExpression == null) throw new InvalidDirectoryStateException("No Derived Expression Selected");
        state.update(new DirectoryState(selectedDerivedExpression));
    }

    public Class<? extends Expression> getExpressionType(){
        return state.get().expression.getType();
    }

    public String getExpressionString(){
        return state.get().expression.toString();
    }

    public Class<? extends Expression> getIteratedExpressionType(){
        Expression selectedDerivedExpression =state.get().derivedExpressionIterator.getIterated();
        if (selectedDerivedExpression == null) throw new InvalidDirectoryStateException("No Derived Expression Selected");
        return selectedDerivedExpression.getType();
    }

    public String getIteratedExpressionString(){
        Expression selectedDerivedExpression =state.get().derivedExpressionIterator.getIterated();
        if (selectedDerivedExpression == null) throw new InvalidDirectoryStateException("No Derived Expression Selected");
        return selectedDerivedExpression.toString();
    }



    public static class InvalidDirectoryStateException extends RuntimeException{
        public InvalidDirectoryStateException() {
        }

        public InvalidDirectoryStateException(String message) {
            super(message);
        }
    }
}
