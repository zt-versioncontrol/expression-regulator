package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        return Set.of(
                new AbstractClassValidator(),
                new FileClassQualifiersValidator(),
                new FileEnumQualifiersValidator(),
                new FileInterfaceQualifiersValidators(),
                new NestedClassQualifiersValidator(),
                new NestedEnumQualifiersValidator(),
                new NestedInterfaceQualifiersValidator()
        );
    }
}
