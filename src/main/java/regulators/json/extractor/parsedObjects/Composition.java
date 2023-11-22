package regulators.json.extractor.parsedObjects;

import base.parsing.StringConstructed;
import regulators.json.extractor.extractors.CompositionBaseExtractor;
import regulators.json.extractor.extractors.CompositionExtensionExtracttor;
import regulators.json.extractor.extractors.CompositionIdentifierExtractor;

public class Composition extends Statement {

    @StringConstructed(extractor = CompositionIdentifierExtractor.class)
    private String identifier;

    @StringConstructed(extractor = CompositionBaseExtractor.class)
    private String base;

    @StringConstructed(extractor = CompositionExtensionExtracttor.class)
    private String extension;
}
