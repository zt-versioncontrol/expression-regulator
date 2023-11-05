package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.FileCLassQualifiersSelector;

import java.util.Set;

public class FileClassQualifiersValidator extends BasicExpressionValidator {


    private final Set<String> keywards = Set.of("public", "final", "abstract");

    protected FileClassQualifiersValidator() {
        super(FileCLassQualifiersSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return keywards.contains(expression.getExpressionString());
    }
}
