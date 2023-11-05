package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.FileInterfaceQualifiersSelector;

import java.util.Set;

public class FileInterfaceQualifiersValidators extends BasicExpressionValidator {

    private final Set<String> keywords = Set.of("public", "abstract");

    protected FileInterfaceQualifiersValidators() {
        super(FileInterfaceQualifiersSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return keywords.contains(expression.getExpressionString());
    }
}
