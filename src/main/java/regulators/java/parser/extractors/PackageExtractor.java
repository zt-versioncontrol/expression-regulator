package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class PackageExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if (!expression.startsWith("package")) return "";

        int semiColon = expression.indexOf(':');
        if (semiColon == -1) return expression;

        return expression.substring(0, semiColon).trim();
    }

    @Override
    protected String normalize(String expression) {
        return expression.trim();
    }
}
