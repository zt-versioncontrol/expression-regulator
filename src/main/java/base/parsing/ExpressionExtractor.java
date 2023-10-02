package base.parsing;


public abstract class ExpressionExtractor extends ExtractorType{
    public String extractFromExpression(String expression){
        // TODO: 9/28/2023 handle parsing exceptions here, both for normalization and extraction
        String normalizedForm = normalize(expression);
        return extract(normalizedForm);
    }

    protected abstract String extract(String expression);
    protected abstract String normalize(String expression);
}
