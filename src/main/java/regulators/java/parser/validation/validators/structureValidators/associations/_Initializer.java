package regulators.java.parser.validation.validators.structureValidators.associations;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        return Set.of(
                new ExtendedInterfacesValidator(),
                new ImplementedInterfacesValidator(),
                new ImportValidator(),
                new SuperClassValidator(),
                new TypeSelectorValidator()
        );
    }
}
