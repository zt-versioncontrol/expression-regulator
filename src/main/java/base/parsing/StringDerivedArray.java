package base.parsing;

import base.components.expression.parsing.ExpressionArrayExtractor;
import base.components.expression.parsing.InstanceProvider;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StringDerivedArray {
    Class<? extends ExpressionArrayExtractor> extractor();
    Class<? extends InstanceProvider> provider();
}
