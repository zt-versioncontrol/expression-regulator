package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;


public class GenericTypeIdentifierExtractor extends ExpressionExtractor {

    @Override
    protected String extract(String expression) {

        int extendsIndex = expression.indexOf(" extends ");
        if (extendsIndex == -1) return expression;
        return expression.substring(0, extendsIndex).trim();
    }

}
