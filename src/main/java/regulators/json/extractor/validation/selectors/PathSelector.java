package regulators.json.extractor.validation.selectors;

import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.extractor.extractors.PathExtractor;

public class PathSelector extends ByExtractor {
    protected PathSelector() {
        super(PathExtractor.class);
    }
}
