package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.extractor.extractors.SelectorTypeExtractor;

public class SelectorTypeSelector extends ByExtractor {
    protected SelectorTypeSelector() {
        super(SelectorTypeExtractor.class);
    }
}
