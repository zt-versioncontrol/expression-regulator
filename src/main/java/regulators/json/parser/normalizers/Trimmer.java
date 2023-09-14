package regulators.json.parser.normalizers;

import base.parsing.ExpressionNormalizer;

public class Trimmer implements ExpressionNormalizer {
    @Override
    public String normalize(String s) {
        return s.trim();
    }
}
