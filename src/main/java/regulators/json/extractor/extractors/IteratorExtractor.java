package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class IteratorExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int equals = expression.indexOf("=");
        if (equals == -1) return "";

        expression = expression.substring(equals+1).trim();

        if (!expression.startsWith("[")) return "";

        int rightBracket = expression.indexOf("]");
        if (rightBracket == -1) return expression;

        return expression.substring(0, rightBracket + 1);
    }
}
