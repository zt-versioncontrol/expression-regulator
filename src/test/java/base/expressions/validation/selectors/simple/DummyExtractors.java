package base.expressions.validation.selectors.simple;

import base.parsing.ExpressionExtractor;

public class DummyExtractors {
    public static class OriginalExtractor extends ExpressionExtractor{

        @Override
        protected String extract(String expression) {
            return null;
        }

        @Override
        protected String normalize(String expression) {
            return null;
        }
    }

    public static class Extractor extends ExpressionExtractor{

        @Override
        protected String extract(String expression) {
            return null;
        }

        @Override
        protected String normalize(String expression) {
            return null;
        }
    }

    public static class DervivedExtractor extends ExpressionExtractor{

        @Override
        protected String extract(String expression) {
            return null;
        }

        @Override
        protected String normalize(String expression) {
            return null;
        }
    }
}
