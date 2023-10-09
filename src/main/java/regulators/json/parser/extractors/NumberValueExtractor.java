package regulators.json.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class NumberValueExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        return expression;
    }

    @Override
    protected String normalize(String expression) {
        return expression.trim();
    }
}
