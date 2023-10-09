package base.components.expression.parsing;


import java.util.List;

public abstract class ExpressionArrayExtractor implements ExtractorType {

    public List<String> extractArrayFromExpression(String expression){
        String normalizedForm = normalize(expression);

        return extract(normalizedForm);
    }


    protected abstract List<String> extract(String expression);
    protected abstract String normalize(String expression);
}
