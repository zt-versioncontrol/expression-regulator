package regulators.java.parser.validation.validators.wordValidators;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.HashSet;
import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        Set<BasicExpressionValidator> validators = new HashSet<>();

        validators.addAll(new regulators.java.parser.validation.validators.wordValidators.identifiers._Initializer().initialize());
        validators.addAll(new regulators.java.parser.validation.validators.wordValidators.qualifiers._Initializer().initialize());

        return validators;
    }
}
