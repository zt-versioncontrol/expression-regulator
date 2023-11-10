package regulators.java.parser.validation.validators.structureValidators;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.HashSet;
import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        Set<BasicExpressionValidator> validators = new HashSet<>();

        validators.addAll(new regulators.java.parser.validation.validators.structureValidators.associations._Initializer().initialize());
        validators.addAll(new regulators.java.parser.validation.validators.structureValidators.attributes._Initializer().initialize());
        validators.addAll(new regulators.java.parser.validation.validators.structureValidators.logic._Initializer().initialize());
        validators.addAll(new regulators.java.parser.validation.validators.structureValidators.members._Initializer().initialize());
        validators.addAll(new regulators.java.parser.validation.validators.structureValidators.types._Initializer().initialize());

        return validators;
    }
}
