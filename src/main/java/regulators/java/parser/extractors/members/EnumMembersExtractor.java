package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.ArrayList;
import java.util.List;

public class EnumMembersExtractor extends ExpressionArrayExtractor {

    public EnumMembersExtractor() {
        super(List.of(
                expression -> {
                    List<Pair<Integer,Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");
                    if (scopes.size() != 1) return false;
                    return scopes.get(0).second == expression.length()-1;
                }
        ), List.of(""));
    }

    @Override
    protected List<String> extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");
        expression = expression.substring(scopes.get(0).first + "{".length(), scopes.get(0).second).trim();
        int firstSemicolon = expression.indexOf(';');

        if (firstSemicolon == -1) return List.of();
        expression = expression.substring(firstSemicolon + ";".length());



        List<Pair<Integer, Integer>> nestedScopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");
        int expressionLength = expression.length();
        List<Integer> unscopedSemiclones = SearchingUtilities.unscopedIndecisOf(expression, nestedScopes, ";");
        List<Integer> scopesEnds = nestedScopes.stream().map(scope-> {
            if (scope.second == -1) return expressionLength -1;
            return scope.second;
        }).toList();

        List<Integer> endPoints = new ArrayList<>(unscopedSemiclones);
        endPoints.addAll(scopesEnds);
        endPoints.sort(Integer::compareTo);

        List<String> members = new ArrayList<>();
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
}
