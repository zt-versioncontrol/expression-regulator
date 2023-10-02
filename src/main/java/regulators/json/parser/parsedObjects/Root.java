package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.JsonExtractor;
import regulators.json.parser.providers.JsonProvider;

public class Root {
    @StringDerived(extractor = JsonExtractor.class, provider = JsonProvider.class)
    Json json;
}
