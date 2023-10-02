package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.JsonNumberExtractor;
import regulators.json.parser.providers.JsonNumberProvider;

public class JsonNumber extends Json{
    @StringDerived(extractor = JsonNumberExtractor.class, provider = JsonNumberProvider.class)
    private double number;
}
