package regulators.json.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class PropertyNameExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        //replace all backslash characters that are followed by double quotes with any appropriet string of length 2
        //those the combination of those two characters indicates a double quote characters inside a string embedded in json
        //they should be removed to facilitate finding string embeded in json
        //replacement should be of length 2 to keep index integrity of expression unchanged
        //for more information refer to json specifications
        String transformedExpression = expression.replaceAll("[\\\\]\"", "**");

        List<Pair<Integer, Integer>> stringScopes = ParsingUtilities.symmetricScopeBoundaries(transformedExpression, "\"");
        List<Integer> unscopedColons = SearchingUtilities.unscopedIndecisOf(expression, stringScopes, ":");

        if(unscopedColons.size() == 0) return "";
        return expression.substring(0, unscopedColons.get(0)).trim();
    }

    @Override
    protected String normalize(String expression) {
        return expression;
    }
}
