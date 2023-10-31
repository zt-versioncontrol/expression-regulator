package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class MethodParametersExtractor extends ExpressionArrayExtractor {
    public MethodParametersExtractor() {
        super(List.of(
                expression -> {
                    //must have parameters
                    //parameters scope must be before definition scope
                    if (!expression.contains("(")) return false;
                    if (!expression.contains("{")) return true;
                    return expression.indexOf("(") < expression.indexOf("{");
                },
                expression -> {
                    List<Pair<Integer,Integer>> scopes =  ParsingUtilities.scopeBoundaries(expression, "(", ")");
                    return scopes.size() > 0 && scopes.get(0).second != -1;
                }
                ),
                List.of(""));
    }

    @Override
    protected List<String> extract(String expression) {
        Pair<Integer, Integer> paramettersScope = ParsingUtilities.firstScopeBoundaries(expression, "(", ")");
        expression = expression.substring(paramettersScope.first+1, paramettersScope.second);

        if (expression.isBlank()) return List.of();

        List<Pair<Integer, Integer>> genericScopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, genericScopes, ",");

        return ParsingUtilities.indexSplit(expression, unscopedCommas).stream().map(String::trim).toList();
    }
}
