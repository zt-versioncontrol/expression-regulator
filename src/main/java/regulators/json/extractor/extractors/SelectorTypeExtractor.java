package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class SelectorTypeExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int as = expression.indexOf("as");

        if (as == -1) return "";

        return expression.substring(as + "as".length()).trim();
    }
}
