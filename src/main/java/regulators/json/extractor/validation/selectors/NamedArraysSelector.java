package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ConcreteTypeSelector;
import regulators.json.extractor.parsedObjects.structure.NamedArrays;

public class NamedArraysSelector extends ConcreteTypeSelector {
    protected NamedArraysSelector() {
        super(NamedArrays.class);
    }
}
