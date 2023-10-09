package base.parsing;

import base.components.expression.parsing.ExpressionArrayExtractor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StringConstructedArray {
    Class<? extends ExpressionArrayExtractor> extractor();
    Class<?> of();
}
