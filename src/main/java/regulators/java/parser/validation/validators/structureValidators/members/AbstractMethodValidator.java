package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectors;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;

public class AbstractMethodValidator extends BasicExpressionValidator {

    protected AbstractMethodValidator() {
        super(ByConcreteTypeSelectors.AbstractMethodSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        if (!expressionString.endsWith(";")) return false;
        expressionString = expressionString.substring(0, expressionString.length()-1).trim();

        List<Pair<Integer,Integer>> scopes = ParsingUtilities.scopeBoundaries(expressionString, "{", "}");
        if (!scopes.isEmpty()) return false;

        scopes = ParsingUtilities.scopeBoundaries(expressionString, "(", ")");
        if (scopes.size() != 1) return false;
        if (scopes.get(0).second != expressionString.length() - 1) return false;

        return true;
    }
}
