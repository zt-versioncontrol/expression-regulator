package regulators.json.parser.parsedObjects;

import base.parsing.StringConstructed;
import regulators.json.parser.extractors.JsonStringExtractor;

public class JsonString extends Json{
    @StringConstructed(extractor = JsonStringExtractor.class)
    private String string;
}
