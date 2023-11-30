package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class StructureExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if (!expression.endsWith(";")) return "";
        expression = expression.substring(0, expression.length()-1);

        int indicator = expression.indexOf(">");
        if (indicator == -1) return "";

        return expression.substring(indicator + ">".length()).trim();
    }
}
