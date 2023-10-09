package base.parsing;

import base.components.expression.parsing.ExpressionExtractor;
import base.components.expression.parsing.InstanceProvider;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StringDerived {
    Class<? extends ExpressionExtractor> extractor();
    Class<? extends InstanceProvider> provider();
}
