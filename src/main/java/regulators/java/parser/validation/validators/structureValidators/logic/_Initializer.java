package regulators.java.parser.validation.validators.structureValidators.logic;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        return Set.of(
                new FieldInitializerValidator(),
                new StatementValidator()
        );
    }
}
