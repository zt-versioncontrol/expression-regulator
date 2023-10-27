package base.components.expression.parsing;


import java.util.ArrayList;
import java.util.List;

public abstract class ExpressionArrayExtractor implements ExtractorType {
    private final List<ExpressionAssumption> assumptions = new ArrayList<>();
    private final List<String> fallBackExpressions;

    public ExpressionArrayExtractor() {
        this.fallBackExpressions = null;
    }

    public ExpressionArrayExtractor(List<ExpressionAssumption> assumptions){
        this.assumptions.addAll(assumptions);
        fallBackExpressions = null;
    }

    public ExpressionArrayExtractor(List<ExpressionAssumption> assumptions, List<String> fallBackExpressions) {
        this.assumptions.addAll(assumptions);
        this.fallBackExpressions = fallBackExpressions;
    }

    public List<String> extractArrayFromExpression(String expression)throws ExpressionAssumption.AssumptionViolationException {
        for (ExpressionAssumption assumption : assumptions) {
            if (!assumption.isSatisfied(expression)){
                if (fallBackExpressions == null) throw new ExpressionAssumption.AssumptionViolationException();
                return fallBackExpressions;
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
