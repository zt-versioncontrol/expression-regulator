package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ConcreteTypeSelector;
import regulators.json.extractor.parsedObjects.statement.Extraction;

public class ExtractionSelector extends ConcreteTypeSelector {
    protected ExtractionSelector() {
        super(Extraction.class);
    }
}
