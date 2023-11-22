package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionAssumption;
import base.components.expression.parsing.ExpressionExtractor;

import java.util.List;

public class RangeStartExtractor extends ExpressionExtractor {

    public RangeStartExtractor() {
        super(List.of(expression -> expression.contains(":")), ":");
    }

    @Override
    protected String extract(String expression) {
        int colon = expression.indexOf(":");

        return expression.substring(0, colon).trim();
    }
}
