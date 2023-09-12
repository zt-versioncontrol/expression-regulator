package base.parsing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StringDerived {
    Class<? extends ExpressionExtractor> extractor();
    Class<? extends InstanceProvider> provider();
}