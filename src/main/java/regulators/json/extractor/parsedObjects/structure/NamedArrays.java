package regulators.json.extractor.parsedObjects.structure;

import base.parsing.StringConstructed;
import regulators.json.extractor.extractors.NamedArraysRootSelectorExtractor;
import regulators.json.extractor.extractors.NamedArraysBranchSelectorExtractor;
import regulators.json.extractor.parsedObjects.bits.CompositionSelector;

public class NamedArrays extends Structure {

    @StringConstructed(extractor = NamedArraysRootSelectorExtractor.class)
    private CompositionSelector rootSelector;

    @StringConstructed(extractor = NamedArraysBranchSelectorExtractor.class)
    private CompositionSelector branchSelector;
}
