package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.ArrayList;
import java.util.List;

public class ClassMembersExtractor extends ExpressionArrayExtractor {
    public ClassMembersExtractor() {
        super(List.of(
                expression -> {
                    var scopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");
                    if (scopes.size() != 1) return false;
                    return scopes.get(0).second == expression.length()-1;
                }),
                "");
    }

    @Override
    protected List<String> extract(String expression) {
        List<String> members = new ArrayList<>();

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");

        List<Integer> unscopedSemiclones = SearchingUtilities.unscopedIndecisOf(expression, scopes, ";");
        List<Integer> scopesEnds = scopes.stream().map(scope-> {
            if (scope.second == -1) return expression.length()-1;
            return scope.second;
        }).toList();

        List<Integer> endPoints = new ArrayList<>(unscopedSemiclones);
        endPoints.addAll(scopesEnds);
        endPoints.sort(Integer::compareTo);

        int start = 0;
        for (Integer endPoint : endPoints) {
            //semicolon or scope end must be included
            members.add(expression.substring(start, endPoint+1).trim());
            start = endPoint +1;
        }
        //if last statement is not terminated, add it
        //spaces at the end of expression are already trimmed, thus resulting expression is not composed of spaces characters
        if (start < expression.length()) members.add(expression.substring(start).trim());

        return members;
    }

    @Override
    protected String normalize(String expression) {
        if (expression.isEmpty()) return expression;
        Pair<Integer, Integer> scope = ParsingUtilities.firstScopeBoundaries(expression, "{", "}");
        return expression.substring(scope.first+"{".length(), scope.second).trim();
    }
}
