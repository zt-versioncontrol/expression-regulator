package regulators.json.parser.extractors;

import base.parsing.ExpressionExtractor;

public class JsonExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        return expression;
    }

    @Override
    protected String normalize(String expression) {
        return expression.trim();
    }
}
