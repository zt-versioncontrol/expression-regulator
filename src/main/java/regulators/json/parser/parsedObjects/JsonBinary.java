package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.PassThroughExtractor;
import regulators.json.parser.providers.JsonBinaryProvider;

public class JsonBinary extends Json{
    @StringDerived(extractor = PassThroughExtractor.class, provider = JsonBinaryProvider.class)
    private boolean binary;
}
