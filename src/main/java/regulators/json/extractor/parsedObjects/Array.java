package regulators.json.extractor.parsedObjects;

import base.parsing.StringConstructed;
import regulators.json.extractor.extractors.ArraySelectorExtractor;

public class Array extends Structure{

    @StringConstructed(extractor = ArraySelectorExtractor.class)
    private CompositionSelector selector;
}
