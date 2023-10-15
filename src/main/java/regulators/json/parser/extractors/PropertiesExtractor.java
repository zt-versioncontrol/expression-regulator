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
        Pair<String, String> arrayScopeIndicators = new Pair<>("[", "]");
        Pair<String, String> objectScopeIndicators = new Pair<>("{", "}");
        String stringScopeIndicator = "\"";

        //replace all backslash characters that are followed by double quotes with any appropriet string of length 2
        //those the combination of those two characters indicates a double quote characters inside a string embedded in json
        //they should be removed to facilitate finding string embeded in json
        //replacement should be of length 2 to keep index integrity of expression unchanged
        //for more information refer to json specifications
        String transformedExpression = expression.replaceAll("[\\\\]\"", "**");

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.noneIntersectedScopeBoundaries(
                transformedExpression, List.of(arrayScopeIndicators, objectScopeIndicators), List.of(stringScopeIndicator)
        );

        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, scopes, ",");

        if (unscopedCommas.size() == 0 && expression.isBlank()) return List.of();

        return ParsingUtilities.indexSplit(expression, unscopedCommas).stream().map(String::trim).toList();
    }

    @Override
    protected String normalize(String expression) {
        if (expression.length() < 2) return "";
        expression = expression.substring(1, expression.length()-1);
        return expression.trim();
    }
}
