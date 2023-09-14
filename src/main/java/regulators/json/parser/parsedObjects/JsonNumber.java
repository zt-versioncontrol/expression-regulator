package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.PassThroughExtractor;
import regulators.json.parser.providers.JsonNumberProvider;

public class JsonNumber extends Json{
    @StringDerived(extractor = PassThroughExtractor.class, provider = JsonNumberProvider.class)
    private double number;
}
