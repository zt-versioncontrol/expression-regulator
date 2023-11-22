package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionExtractor;

import java.util.List;

public class ArraySelectorExtractor extends ExpressionExtractor {

    public ArraySelectorExtractor() {
        super(List.of(expression -> expression.startsWith("[") && expression.endsWith("]")), "");
    }

    @Override
    protected String extract(String expression) {
        return expression.substring(1, expression.length()-1);
    }
}
