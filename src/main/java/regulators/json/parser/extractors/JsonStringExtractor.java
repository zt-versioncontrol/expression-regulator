package regulators.json.parser.extractors;

import base.parsing.ExpressionExtractor;

public class JsonStringExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        return expression.substring(1, expression.length()-1);
    }

    @Override
    protected String normalize(String expression) {
        return expression.trim();
    }
}
