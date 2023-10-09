package regulators.json.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class PropertyNameExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if(!expression.contains(":")) return expression;
        return expression.substring(0, expression.indexOf(':')).trim();
    }

    @Override
    protected String normalize(String expression) {
        return expression.trim();
    }
}
