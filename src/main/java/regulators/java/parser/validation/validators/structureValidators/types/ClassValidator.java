package regulators.java.parser.validation.validators.structureValidators.types;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectors;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;

public class ClassValidator extends BasicExpressionValidator {
    protected ClassValidator() {
        super(ByConcreteTypeSelectors.ClassSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();
        List<Pair<Integer,Integer>> scopes = ParsingUtilities.scopeBoundaries(expressionString, "{", "}");

        if (scopes.size() != 1 || scopes.get(0).second != expressionString.length()-1) return false;

        String folded = ManipulationUtilities.foldScopes(expressionString, "{", "}", "");
        folded = ManipulationUtilities.foldScopes(folded, "<", ">", "");

        return folded.startsWith("class ") || folded.contains(" class ");
    }
}
