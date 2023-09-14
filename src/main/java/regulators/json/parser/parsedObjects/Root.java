package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.PassThroughExtractor;
import regulators.json.parser.providers.JsonProvider;

public class Root {
    @StringDerived(extractor = PassThroughExtractor.class, provider = JsonProvider.class)
    Json json;
}
