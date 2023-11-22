package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class ExtractionIdentifierExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int indicator = expression.indexOf("<<");
        if (indicator == -1) return "";

        return expression.substring(0, indicator).trim();
    }
}
