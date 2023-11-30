package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ConcreteTypeSelector;
import regulators.json.extractor.parsedObjects.statement.Composition;

public class CompositionSelector extends ConcreteTypeSelector {
    protected CompositionSelector() {
        super(Composition.class);
    }
}
