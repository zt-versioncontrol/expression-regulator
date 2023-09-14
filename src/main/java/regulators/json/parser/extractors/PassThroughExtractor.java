package regulators.json.parser.extractors;

import base.parsing.ExpressionExtractor;
import base.parsing.ExpressionNormalizer;
import regulators.json.parser.normalizers.Trimmer;

public class PassThroughExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        return expression;
    }

    @Override
    protected ExpressionNormalizer getNormalizer() {
        return new Trimmer();
    }
}
