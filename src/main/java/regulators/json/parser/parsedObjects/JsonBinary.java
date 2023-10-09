package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.BinaryValueExtractor;
import regulators.json.parser.providers.JsonBinaryProvider;

public class JsonBinary extends Json{
    @StringDerived(extractor = BinaryValueExtractor.class, provider = JsonBinaryProvider.class)
    private Boolean value;
}
