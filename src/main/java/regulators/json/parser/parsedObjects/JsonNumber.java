package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.NumberValueExtractor;
import regulators.json.parser.providers.NumberValueProvider;

public class JsonNumber extends Json{
    @StringDerived(extractor = NumberValueExtractor.class, provider = NumberValueProvider.class)
    private Double value;

    public Double getValue() {
        return value;
    }
}
