package base.parsing;


public abstract class ExpressionExtractor {
    private final ExpressionNormalizer normalizer;


    protected ExpressionExtractor() {
        this.normalizer = getNormalizer();
    }

    public String extractFromExpression(String expression){
        // TODO: 9/28/2023 handle parsing exceptions here, both for normalization and extraction
        String normalizedForm = normalizer.normalize(expression);
        return extract(normalizedForm);
    }

    protected abstract String extract(String expression);
    protected abstract ExpressionNormalizer getNormalizer();
}
