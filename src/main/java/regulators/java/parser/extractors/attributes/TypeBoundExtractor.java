package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;

public class TypeBoundExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int extendsIndex = expression.indexOf(" extends ");
        if (extendsIndex == -1) return "";

        return expression.substring(extendsIndex+" extends ".length()).trim();
    }
}
