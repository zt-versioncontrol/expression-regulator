package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.GenericsSelector;
import utility.string.ManipulationUtilities;

public class GenericsValidator extends BasicExpressionValidator {


    protected GenericsValidator() {
        super(GenericsSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();
        return expressionString.startsWith("<") && expressionString.endsWith(">") &&
                ManipulationUtilities.foldCharacters(expressionString, Character::isWhitespace, "").length() > 2;
    }
}
