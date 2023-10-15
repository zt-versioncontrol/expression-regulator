package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.PropertyExpressionSelector;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class PropertyValidator extends BasicExpressionValidator {

    public PropertyValidator(){
        super(PropertyExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        String transformedExpression = expressionString.replaceAll("[\\\\]\"", "**");

        List<Pair<Integer, Integer>> stringScopes = ParsingUtilities.symmetricScopeBoundaries(transformedExpression, "\"");
        List<Integer> unscopedColons = SearchingUtilities.unscopedIndecisOf(expressionString, stringScopes, ":");

        return unscopedColons.size() != 0;
    }
}
