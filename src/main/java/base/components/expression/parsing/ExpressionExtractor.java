package base.components.expression.parsing;


import java.util.ArrayList;
import java.util.List;

public abstract class ExpressionExtractor implements ExtractorType {
    private final List<ExpressionAssumption> assumptions = new ArrayList<>();
    private final String fallBackExpression;

    public ExpressionExtractor() {
        this.fallBackExpression = null;
    }

    public ExpressionExtractor(List<ExpressionAssumption> assumptions){
        this.assumptions.addAll(assumptions);
        fallBackExpression = null;
    }

    public ExpressionExtractor(List<ExpressionAssumption> assumptions, String fallBackExpression) {
        this.assumptions.addAll(assumptions);
        this.fallBackExpression = fallBackExpression;
    }

    public String extractFromExpression(String expression) throws ExpressionAssumption.AssumptionViolationException {
        for (ExpressionAssumption assumption : assumptions) {
            if (!assumption.isSatisfied(expression)){
                if (fallBackExpression == null) throw new ExpressionAssumption.AssumptionViolationException();
                return fallBackExpression;
            }
        }

        String normalizedForm = normalize(expression);
        return extract(normalizedForm);
    }


    protected abstract String extract(String expression);
    protected String normalize(String expression){
        return expression;
    }


}
