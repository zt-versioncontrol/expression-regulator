package regulators.java.parser.extractors.logic;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.ArrayList;
import java.util.List;

public class StatementsExtractor extends ExpressionArrayExtractor {

    public StatementsExtractor() {
        super(List.of(expression -> {
            expression = ManipulationUtilities.foldScopes(expression, "(", ")", "()");

            List<Pair<Integer, Integer>> definitionScopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");
            if (definitionScopes.size() != 1) return false;
            return definitionScopes.get(0).second == expression.length() - 1;
        }), List.of(""));
    }

    @Override
    protected List<String> extract(String expression) {
        //cancel the effect of "{" embedded in "()"
        List<Pair<Integer, Integer>> noneIntersectingScopes = ParsingUtilities.noneIntersectedScopeBoundaries(expression, List.of(new Pair<>("{", "}"), new Pair<>("(", ")")), List.of());
        //last scope is function definition according to assumptions
        Pair<Integer, Integer> scope = noneIntersectingScopes.get(noneIntersectingScopes.size()-1);
        expression = expression.substring(scope.first+1, scope.second).trim();

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");
        List<Integer> unscopedSemicolons = SearchingUtilities.unscopedIndecisOf(expression, scopes, ";");

        //a statement either end with semicolon or scope closure
        List<Integer> statementEnds = new ArrayList<>();
        statementEnds.addAll(unscopedSemicolons);
        int expressionEnd = expression.length() - 1;
        statementEnds.addAll(
                scopes.stream().map( pair -> pair.second == -1? expressionEnd : pair.second).toList()
        );
        statementEnds.sort(Integer::compareTo);


        List<String> statements = new ArrayList<>();
        int start = 0;
        for (Integer statementEnd : statementEnds) {
            //semicolon or scope end must be included
            statements.add(expression.substring(start, statementEnd + 1).trim());
            start = statementEnd + 1;
        }
        //if last statement is not terminated, add it
        //spaces at the end of expression are already trimmed, thus resulting expression is not composed of spaces characters
        if (start != expression.length()) statements.add(expression.substring(start).trim());

        return statements;
    }
}
