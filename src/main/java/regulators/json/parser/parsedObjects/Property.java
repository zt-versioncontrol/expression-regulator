package regulators.json.parser.parsedObjects;

import base.parsing.StringConstructed;
import base.parsing.StringDerived;
import regulators.json.parser.extractors.PassThroughExtractor;
import regulators.json.parser.extractors.PropertyNameExtractor;
import regulators.json.parser.providers.JsonProvider;

public class Property {
    @StringConstructed(extractor = PropertyNameExtractor.class)
    private String name;
    @StringDerived(extractor = PassThroughExtractor.class, provider = JsonProvider.class)
    private Json value;
}