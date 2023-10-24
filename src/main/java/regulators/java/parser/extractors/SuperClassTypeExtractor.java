package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class SuperClassTypeExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if(!expression.startsWith("extends ")) return "";
        return expression.substring("extends ".length()).trim();
    }
}
