package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ConcreteTypeSelector;
import regulators.json.extractor.parsedObjects.statement.Segment;

public class SegmentSelector extends ConcreteTypeSelector {
    protected SegmentSelector() {
        super(Segment.class);
    }
}
