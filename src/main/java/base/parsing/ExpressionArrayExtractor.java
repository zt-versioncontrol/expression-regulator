package base.parsing;


import java.util.List;

public abstract class ExpressionArrayExtractor extends ExtractorType{

    public List<String> extractArrayFromExpression(String expression){
        String normalizedForm = normalize(expression);

        return extract(normalizedForm);
    }


    protected abstract List<String> extract(String expression);
    protected abstract String normalize(String expression);
}
