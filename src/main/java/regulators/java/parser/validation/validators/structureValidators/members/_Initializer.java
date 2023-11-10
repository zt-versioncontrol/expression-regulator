package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        return Set.of(
                new AbstractMethodValidator(),
                new EmptyMemberValidator(),
                new GenericsValidator(),
                new InitializationBlockValidator(),
                new MethodValidator(),
                new StaticBlockValidator(),
                new TypeMemberValidator()
        );
    }
}
