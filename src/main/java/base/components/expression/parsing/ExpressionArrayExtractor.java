package base.components.expression.parsing;


import java.util.ArrayList;
import java.util.List;

public abstract class ExpressionArrayExtractor implements ExtractorType {
    private final List<ExpressionAssumption> assumptions = new ArrayList<>();
    private final String fallBackExpression;

    public ExpressionArrayExtractor() {
        this.fallBackExpression = null;
    }

    public ExpressionArrayExtractor(List<ExpressionAssumption> assumptions){
        this.assumptions.addAll(assumptions);
        fallBackExpression = null;
    }

    public ExpressionArrayExtractor(List<ExpressionAssumption> assumptions, String fallBackExpression) {
        this.assumptions.addAll(assumptions);
        this.fallBackExpression = fallBackExpression;
    }

    public List<String> extractArrayFromExpression(String expression)throws ExpressionAssumption.AssumptionViolationException {
        for (ExpressionAssumption assumption : assumptions) {
            if (!assumption.isSatisfied(expression)){
                if (fallBackExpression == null) throw new ExpressionAssumption.AssumptionViolationException();
                expression = fallBackExpression;
                break;
            }
        }

        String normalizedForm = normalize(expression);
        return extract(normalizedForm);
    }


    protected abstract List<String> extract(String expression);
    protected String normalize(String expression){
        return expression;
    }
}
