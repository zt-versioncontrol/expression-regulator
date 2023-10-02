package regulators.json.parser.extractors;

import base.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayElementsExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        var arrayScopes = ParsingUtilities.depthOneScopeBoundaries(expression, "[", "]");
        var objectScopes = ParsingUtilities.depthOneScopeBoundaries(expression, "{", "}");
        var stringScopes1 = ParsingUtilities.symmetricScopeBoundaries(expression, "\"");
        var stringScopes2 = ParsingUtilities.symmetricScopeBoundaries(expression, "'");

        List<Pair<Integer, Integer>> scopes = new ArrayList<>();
        scopes.addAll(arrayScopes);
        scopes.addAll(objectScopes);
        scopes.addAll(stringScopes1);
        scopes.addAll(stringScopes2);

        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, scopes, ",");

        return ParsingUtilities.indexSplit(expression, unscopedCommas);
    }

    @Override
    protected String normalize(String expression) {
        expression = expression.trim();
        expression = expression.substring(1, expression.length()-1);
        return expression.trim();
    }
}
