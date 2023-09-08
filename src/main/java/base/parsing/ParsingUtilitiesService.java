package base.parsing;

public interface ParsingUtilitiesService {
    public ExpressionExtractor getExpressionExtractor(Class<? extends ExpressionExtractor> extractorClass);

    public ExpressionArrayExtractor getExpressionArrayExtractor(Class<? extends ExpressionArrayExtractor> extractorClass);

    public InstanceProvider getInstanceProvider(Class<? extends InstanceProvider> providerClass);
}
