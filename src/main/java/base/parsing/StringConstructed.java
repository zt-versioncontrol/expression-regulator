package base.parsing;

import base.components.expression.parsing.ExpressionExtractor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StringConstructed {
    Class<? extends ExpressionExtractor> extractor();
}
