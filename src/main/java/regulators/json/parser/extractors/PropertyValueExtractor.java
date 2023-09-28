package regulators.json.parser.extractors;

import base.parsing.ExpressionExtractor;
import base.parsing.ExpressionNormalizer;
import regulators.json.parser.normalizers.Trimmer;

public class PropertyValueExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        if (!expression.contains(":")) return "";
        return expression.substring(expression.indexOf(":")+1);
    }

    @Override
    protected ExpressionNormalizer getNormalizer() {
        return new Trimmer();
    }
}
