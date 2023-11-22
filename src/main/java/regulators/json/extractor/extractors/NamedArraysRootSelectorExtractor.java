package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class NamedArraysRootSelectorExtractor extends ExpressionExtractor {

    @Override
    protected String extract(String expression) {
        if (!expression.startsWith("{")) return "";

        int comma = expression.indexOf(",");
        if (comma == -1) return "";

        return expression.substring(1, comma).trim();
    }
}
