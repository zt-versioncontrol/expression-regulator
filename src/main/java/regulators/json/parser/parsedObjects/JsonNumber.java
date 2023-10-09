package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.NumberValueExtractor;
import regulators.json.parser.providers.JsonNumberProvider;

public class JsonNumber extends Json{
    @StringDerived(extractor = NumberValueExtractor.class, provider = JsonNumberProvider.class)
    private Double value;
}
