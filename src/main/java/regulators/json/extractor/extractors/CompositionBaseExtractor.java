package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class CompositionBaseExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int indicator = expression.indexOf("<");

        if (indicator == -1) return "";
        expression = expression.substring(indicator + 1);

        int comma = expression.indexOf(",");
        if (comma == -1) return expression.trim();

        return expression.substring(0, comma).trim();
    }
}
