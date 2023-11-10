package regulators.java.parser.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.HashSet;
import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        Set<BasicExpressionValidator> validators = new HashSet<>();

        validators.add(new InvalidTypeValidator());
        validators.addAll(new regulators.java.parser.validation.validators.structureValidators._Initializer().initialize());
        validators.addAll(new regulators.java.parser.validation.validators.wordValidators._Initializer().initialize());

        return validators;
    }
}
