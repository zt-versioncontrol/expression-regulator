package regulators.json.extractor.parsedObjects.structure;

import base.parsing.StringConstructed;
import regulators.json.extractor.extractors.ArraySelectorExtractor;
import regulators.json.extractor.parsedObjects.bits.CompositionSelector;

public class Array extends Structure {

    @StringConstructed(extractor = ArraySelectorExtractor.class)
    private CompositionSelector selector;
}
