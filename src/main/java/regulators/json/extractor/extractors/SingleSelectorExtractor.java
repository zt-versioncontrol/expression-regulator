package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class SingleSelectorExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        return expression;
    }
}
