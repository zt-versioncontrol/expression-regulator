package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class SelectorIdentifierExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int as = expression.indexOf("as");

        if (as == -1) return expression;

        return expression.substring(0, as).trim();
    }
}
