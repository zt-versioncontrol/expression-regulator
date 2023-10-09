package regulators.json.parser.parsedObjects;

import base.parsing.StringConstructed;
import regulators.json.parser.extractors.StringValueExtractor;

public class JsonString extends Json{
    @StringConstructed(extractor = StringValueExtractor.class)
    private String value;
}
