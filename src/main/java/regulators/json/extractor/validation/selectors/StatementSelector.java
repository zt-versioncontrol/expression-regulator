package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.extractor.extractors.StatementsExtractor;

public class StatementSelector extends ByExtractor {
    protected StatementSelector() {
        super(StatementsExtractor.class);
    }
}
