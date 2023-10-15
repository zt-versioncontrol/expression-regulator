package regulators.json.parser.parsedObjects;

import base.parsing.AbstractType;
import base.parsing.StringDerived;
import regulators.json.parser.extractors.JsonExtractor;
import regulators.json.parser.providers.JsonProvider;

public class JsonRoot {
    @AbstractType
    @StringDerived(extractor = JsonExtractor.class, provider = JsonProvider.class)
    private Json json;

    public Json getJson() {
        return json;
    }
}
