package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

import java.util.List;

public class RangeEndExtractor extends ExpressionExtractor {

    public RangeEndExtractor() {
        super(List.of(expression -> expression.contains(":")), ":");
    }

    @Override
    protected String extract(String expression) {
        int colon = expression.indexOf(":");

        return expression.substring(colon + 1).trim();
    }
}
