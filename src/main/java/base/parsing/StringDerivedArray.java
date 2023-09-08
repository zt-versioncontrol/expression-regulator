package base.parsing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StringDerivedArray {
    Class<? extends ExpressionArrayExtractor> extractor();
    Class<? extends InstanceProvider> provider();
}
