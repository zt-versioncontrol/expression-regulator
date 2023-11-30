package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.extractor.extractors.IteratorExtractor;

public class IteratorSelector extends ByExtractor {
    protected IteratorSelector() {
        super(IteratorExtractor.class);
    }
}
