package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ConcreteTypeSelector;
import regulators.json.extractor.parsedObjects.structure.Array;

public class ArraySelector extends ConcreteTypeSelector {
    protected ArraySelector() {
        super(Array.class);
    }
}
