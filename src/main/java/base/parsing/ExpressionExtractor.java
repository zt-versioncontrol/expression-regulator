package base.parsing;

public abstract class ExpressionExtractor {
    private final ExpressionNormalizer normalizer;

    protected ExpressionExtractor() {
        this.normalizer = getNormalizer();
    }

    public String extractFromExpression(String expression){
        expression = normalizer.normalize(expression);

        return extract(expression);
    }

    protected abstract String extract(String expression);
    protected abstract ExpressionNormalizer getNormalizer();
}
