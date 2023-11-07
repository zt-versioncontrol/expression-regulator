package regulators.java.parser.validation.validators.structureValidators.associations;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.TypeSelectorSelector;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;

public class TypeSelectorValidator extends BasicExpressionValidator {


    protected TypeSelectorValidator() {
        super(TypeSelectorSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();
        if (expressionString.isBlank()) return false;

        List<Pair<Integer,Integer>> scopes = ParsingUtilities.scopeBoundaries(expressionString, "<", ">");

        if (scopes.isEmpty()) return true;
        if (scopes.size() > 1) return false;
        if (scopes.get(0).second != expressionString.length()-1) return false;

        return true;
    }
}
