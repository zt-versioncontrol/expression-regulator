package base.parsing;


import java.util.List;

public abstract class ExpressionArrayExtractor {
    private final ExpressionNormalizer normalizer;

    public ExpressionArrayExtractor() {
        normalizer = getNormalizer();
    }

    public List<String> extractArrayFromExpression(String expression){
        String normalizedForm = normalizer.normalize(expression);

        return extract(normalizedForm);
    }


    protected abstract List<String> extract(String expression);
    protected abstract ExpressionNormalizer getNormalizer();
}
