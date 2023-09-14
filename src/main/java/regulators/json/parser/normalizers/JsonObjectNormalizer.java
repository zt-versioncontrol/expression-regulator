package regulators.json.parser.normalizers;

import base.parsing.ExpressionNormalizer;

public class JsonObjectNormalizer implements ExpressionNormalizer {

    @Override
    public String normalize(String s) {
        s = s.trim();
        s = s.substring(0, s.length()-1);
        return s.trim();
    }
}
