package regulators.json.extractor.parsedObjects;

import base.parsing.StringConstructed;
import regulators.json.extractor.extractors.SingleSelectorExtractor;

public class Single extends Structure{

    @StringConstructed(extractor = SingleSelectorExtractor.class)
    private CompositionSelector selector;
}
