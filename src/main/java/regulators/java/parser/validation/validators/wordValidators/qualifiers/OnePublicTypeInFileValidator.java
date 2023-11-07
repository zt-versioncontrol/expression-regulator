package regulators.java.parser.validation.validators.wordValidators.qualifiers;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.FileTypeDefinitionQualifiersSelector;

public class OnePublicTypeInFileValidator extends BasicExpressionValidator {
    private boolean publicEncountered = false;

    protected OnePublicTypeInFileValidator() {
        super(FileTypeDefinitionQualifiersSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        if (publicEncountered && expression.getExpressionString().equals("public")) return false;
        if (expression.getExpressionString().equals("public")) publicEncountered = true;
        return true;
    }
}
