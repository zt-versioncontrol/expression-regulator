package regulators.json.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class BinaryValueExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        return expression.toLowerCase();
    }

    @Override
    protected String normalize(String expression) {
        return expression;
    }

}
