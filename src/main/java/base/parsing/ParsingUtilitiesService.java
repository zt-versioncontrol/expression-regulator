package base.parsing;

import base.components.expression.parsing.ExpressionArrayExtractor;
import base.components.expression.parsing.ExpressionExtractor;
import base.components.expression.parsing.InstanceProvider;

import java.util.HashMap;
import java.util.Map;

public class ParsingUtilitiesService {
    private final Map<Class<? extends ExpressionExtractor>, ExpressionExtractor> extractorMap = new HashMap<>();
    private final Map<Class<? extends ExpressionArrayExtractor>, ExpressionArrayExtractor> arrayExtractorMap = new HashMap<>();
    private final Map<Class<? extends InstanceProvider>, InstanceProvider> instanceProviderMap = new HashMap<>();

    public ExpressionExtractor getExpressionExtractor(Class<? extends ExpressionExtractor> extractorClass){
        return extractorMap.get(extractorClass);
    }

    public ExpressionArrayExtractor getExpressionArrayExtractor(Class<? extends ExpressionArrayExtractor> extractorClass){
        return arrayExtractorMap.get(extractorClass);
    }

    public InstanceProvider getInstanceProvider(Class<? extends InstanceProvider> providerClass){
        return instanceProviderMap.get(providerClass);
    }

    public void addExpressionExtractor(ExpressionExtractor extractor){
        extractorMap.put(extractor.getClass(), extractor);
    }

    public void addExpressionArrayExtractor(ExpressionArrayExtractor extractor){
        arrayExtractorMap.put(extractor.getClass(), extractor);
    }

    public void addInstanceProvider(InstanceProvider provider){
        instanceProviderMap.put(provider.getClass(), provider);
    }
}
