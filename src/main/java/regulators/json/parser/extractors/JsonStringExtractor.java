package regulators.json.parser.extractors;

import base.parsing.ExpressionExtractor;
import base.parsing.ExpressionNormalizer;
import regulators.json.parser.normalizers.Trimmer;

public class JsonStringExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        return expression.substring(1, expression.length()-1);
    }

    @Override
    protected ExpressionNormalizer getNormalizer() {
        return new Trimmer();
    }
}
