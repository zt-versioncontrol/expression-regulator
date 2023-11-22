package regulators.json.extractor.parsedObjects;

import base.parsing.StringConstructed;
import regulators.json.extractor.extractors.NamedArraysRootSelectorExtractor;
import regulators.json.extractor.extractors.NamedArraysBranchSelectorExtractor;

public class NamedArrays extends Structure{

    @StringConstructed(extractor = NamedArraysRootSelectorExtractor.class)
    private CompositionSelector rootSelector;

    @StringConstructed(extractor = NamedArraysBranchSelectorExtractor.class)
    private CompositionSelector branchSelector;
}
