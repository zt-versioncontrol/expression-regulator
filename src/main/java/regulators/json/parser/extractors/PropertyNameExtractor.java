package regulators.json.parser.extractors;

import base.parsing.ExpressionExtractor;
import base.parsing.ExpressionNormalizer;
import regulators.json.parser.normalizers.Trimmer;

public class PropertyNameExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        return expression.substring(0, expression.indexOf(':')).trim();
    }

    @Override
    protected ExpressionNormalizer getNormalizer() {
        return new Trimmer();
    }
}
