package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.FileEnumQualifiersSelector;

public class FileEnumQualifiersValidator extends BasicExpressionValidator {

    protected FileEnumQualifiersValidator() {
        super(FileEnumQualifiersSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().equals("public");
    }
}
