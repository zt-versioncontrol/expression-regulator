package base.parsing;


public abstract class ExpressionExtractor {
    private final ExpressionNormalizer normalizer;


    protected ExpressionExtractor() {
        this.normalizer = getNormalizer();
    }

    public String extractFromExpression(String expression){
        String normalizedForm = normalizer.normalize(expression);
        return extract(normalizedForm);
    }

    protected abstract String extract(String expression);
    protected abstract ExpressionNormalizer getNormalizer();
}
