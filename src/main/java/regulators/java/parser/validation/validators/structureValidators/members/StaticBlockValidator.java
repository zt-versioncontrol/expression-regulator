package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectos;
import utility.string.ManipulationUtilities;

public class StaticBlockValidator extends BasicExpressionValidator {

    protected StaticBlockValidator() {
        super(ByConcreteTypeSelectos.StaticBlockSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();
        expressionString = ManipulationUtilities.foldCharacters(expressionString, Character::isWhitespace, " ");

        return (expressionString.startsWith("static{") || expressionString.startsWith("static {")) &&
                expressionString.endsWith("}");
    }
}
