package regulators.json.parser.extractors;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.ArrayList;
import java.util.List;

public class PropertiesExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        var objectScpes = ParsingUtilities.depthOneScopeBoundaries(expression, "{", "}");
        var arrayScopes = ParsingUtilities.depthOneScopeBoundaries(expression, "[", "]");
        var stringScopes1 = ParsingUtilities.symmetricScopeBoundaries(expression, "\"");
        var stringScopes2 = ParsingUtilities.symmetricScopeBoundaries(expression, "'");

        List<Pair<Integer, Integer>> scopes = new ArrayList<>();
        scopes.addAll(objectScpes);
        scopes.addAll(arrayScopes);
        scopes.addAll(stringScopes1);
        scopes.addAll(stringScopes2);

        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, scopes, ",");

        return ParsingUtilities.indexSplit(expression, unscopedCommas).stream().map(String::trim).toList();
    }

    @Override
    protected String normalize(String expression) {
        expression = expression.trim();
        expression = expression.substring(0, expression.length()-1);
        return expression.trim();
    }
}
