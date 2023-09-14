package regulators.json.parser.extractors;

import base.parsing.ExpressionArrayExtractor;
import base.parsing.ExpressionNormalizer;
import regulators.json.parser.normalizers.JsonObjectNormalizer;

import java.util.List;

public class PropertiesExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        return List.of(expression.split(","));
    }

    @Override
    protected ExpressionNormalizer getNormalizer() {
        return new JsonObjectNormalizer();
    }
}
