package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

import java.util.List;

public class PathExtractor extends ExpressionExtractor {

    public PathExtractor() {
        super(List.of(expression -> expression.endsWith(";")), ";");
    }

    @Override
    protected String extract(String expression) {
        //remove semicolon
        expression = expression.substring(0, expression.length()-1);

        int equals = expression.indexOf("=");
        if (equals == -1) return "";

        expression = expression.substring(equals + 1).trim();

        if (expression.startsWith("[")){
            int rightBracket = expression.indexOf("]");
            if (rightBracket == -1) return "";

            return expression.substring(rightBracket+1).trim();
        }

        return expression;
    }
}
