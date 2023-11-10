package regulators.java.parser.validation.validators.wordValidators.qualifiers.members;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        return Set.of(
                new AbstractMethodInClassQualifiersValidator(),
                new AbstractMethodQualifiersValidator(),
                new FieldQualifiersValidator(),
                new InterfaceMemberQualifiersValidator(),
                new MethodQualifiersValidator()
        );
    }
}
