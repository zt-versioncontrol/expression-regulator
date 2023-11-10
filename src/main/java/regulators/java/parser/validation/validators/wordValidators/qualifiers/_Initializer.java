package regulators.java.parser.validation.validators.wordValidators.qualifiers;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.HashSet;
import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionValidator> initialize(){
        Set<BasicExpressionValidator> validators = new HashSet<>();

        validators.add(new OnePublicTypeInFileValidator());
        validators.add(new UniqueQualifiersValidator());
        validators.addAll(new regulators.java.parser.validation.validators.wordValidators.qualifiers.types._Initializer().initialize());
        validators.addAll(new regulators.java.parser.validation.validators.wordValidators.qualifiers.members._Initializer().initialize());

        return validators;
    }
}
