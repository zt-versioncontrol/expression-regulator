package regulators.json.parser.normalizers;

import base.parsing.ExpressionNormalizer;

public class JsonArrayNormalizer implements ExpressionNormalizer {
    @Override
    public String normalize(String s) {
        s = s.trim();
        s = s.substring(1, s.length()-1);
        return s.trim();
    }
}
