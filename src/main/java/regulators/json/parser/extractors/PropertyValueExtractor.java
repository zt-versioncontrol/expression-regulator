package regulators.json.parser.extractors;

import base.parsing.ExpressionExtractor;

public class PropertyValueExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if (!expression.contains(":")) return "";
        return expression.substring(expression.indexOf(":")+1);
    }

    @Override
    protected String normalize(String expression) {
        return expression.trim();
    }
}
