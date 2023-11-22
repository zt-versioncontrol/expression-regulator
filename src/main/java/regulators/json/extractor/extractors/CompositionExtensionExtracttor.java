package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class CompositionExtensionExtracttor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if (!expression.endsWith(";")) return "";

        expression = expression.substring(0, expression.length()-1);

        int indicator = expression.indexOf("<");
        if (indicator == -1) return "";
        expression = expression.substring(indicator+1);

        int colon = expression.indexOf(",");
        if (colon == -1) return "";

        return expression.substring(colon+1).trim();
    }
}
