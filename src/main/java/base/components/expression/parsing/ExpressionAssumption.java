package base.components.expression.parsing;

public interface ExpressionAssumption {
    boolean isSatisfied(String expression);

    class AssumptionViolationException extends RuntimeException {
    }
}
