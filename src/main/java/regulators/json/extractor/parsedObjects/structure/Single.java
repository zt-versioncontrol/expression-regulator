package regulators.json.extractor.parsedObjects.structure;

import base.parsing.StringConstructed;
import regulators.json.extractor.extractors.SingleSelectorExtractor;
import regulators.json.extractor.parsedObjects.bits.CompositionSelector;

public class Single extends Structure {

    @StringConstructed(extractor = SingleSelectorExtractor.class)
    private CompositionSelector selector;
}
