package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

public class SegmentIdentifierExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int index = expression.indexOf("=");
        if (index == -1) return "";
        return expression.substring(0, index).trim();
    }
}
