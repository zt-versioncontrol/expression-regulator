package regulators.java.parser.validation.validators.wordValidators.identifiers;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        return Set.of(
                new IdentifierIsNotKeyWordValidator(),
                new IdentifierValidator()
        );
    }
}
