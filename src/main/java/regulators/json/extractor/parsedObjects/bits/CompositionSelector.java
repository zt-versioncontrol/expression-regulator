package regulators.json.extractor.parsedObjects.bits;

import base.parsing.StringConstructed;
import regulators.json.extractor.extractors.SelectorIdentifierExtractor;
import regulators.json.extractor.extractors.SelectorTypeExtractor;

public class CompositionSelector {

    public CompositionSelector(String expression) {}

    @StringConstructed(extractor = SelectorIdentifierExtractor.class)
    private String compositionIdentifier;

    @StringConstructed(extractor = SelectorTypeExtractor.class)
    private String type;
}
