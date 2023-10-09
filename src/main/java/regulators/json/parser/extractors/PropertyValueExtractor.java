package regulators.json.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class PropertyValueExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if (!expression.contains(":")) return "";
        return expression.substring(expression.indexOf(":")+1).trim();
    }

    @Override
    protected String normalize(String expression) {
        return expression.trim();
    }
}
