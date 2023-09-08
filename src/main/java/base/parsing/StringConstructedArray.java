package base.parsing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StringConstructedArray {
    Class<? extends ExpressionArrayExtractor> extractor();
    Class of();
}
