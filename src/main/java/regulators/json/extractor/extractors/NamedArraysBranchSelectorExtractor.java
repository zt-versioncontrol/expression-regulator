package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class NamedArraysBranchSelectorExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if (!expression.endsWith("}")) return "";

        int comma = expression.indexOf(",");
        if (comma == -1) return "";

        return expression.substring(comma + 1, expression.length() - 1).trim();
    }
}
