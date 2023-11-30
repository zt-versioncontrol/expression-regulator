package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.HasDerivedByExtractor;
import regulators.json.extractor.extractors.SelectorIdentifierExtractor;

public class CompositionSelctorSelector extends HasDerivedByExtractor {
    protected CompositionSelctorSelector() {
        super(SelectorIdentifierExtractor.class);
    }
}
