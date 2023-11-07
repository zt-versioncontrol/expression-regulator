package regulators.java.parser.validation.validators.structureValidators.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectos;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;

public class MethodValidator extends BasicExpressionValidator {

    protected MethodValidator() {
        super(ByConcreteTypeSelectos.MethodSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();
        List<Pair<Integer,Integer>> scopes = ParsingUtilities.noneIntersectedScopeBoundaries(
                expressionString,
                List.of(new Pair<>("(", ")"), new Pair<>("{","}")),
                List.of()
        );

        if (scopes.size() != 2) return false;
        if (expressionString.charAt(scopes.get(0).first) != '(' || expressionString.charAt(scopes.get(1).first) != '{') return false;
        if (scopes.get(1).second != expressionString.length()-1) return false;

        return true;
    }
}
