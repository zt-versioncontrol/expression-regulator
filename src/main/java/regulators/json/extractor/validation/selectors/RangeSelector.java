package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.extractor.extractors.RangesExtractor;

public class RangeSelector extends ByExtractor {
    protected RangeSelector() {
        super(RangesExtractor.class);
    }
}
