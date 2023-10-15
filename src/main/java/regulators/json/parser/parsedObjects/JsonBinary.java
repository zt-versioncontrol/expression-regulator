package regulators.json.parser.parsedObjects;

import base.parsing.StringDerived;
import regulators.json.parser.extractors.BinaryValueExtractor;
import regulators.json.parser.providers.BinaryValueProvider;

public class JsonBinary extends Json{
    @StringDerived(extractor = BinaryValueExtractor.class, provider = BinaryValueProvider.class)
    private Boolean value;

    public Boolean getValue() {
        return value;
    }
}
