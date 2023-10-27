package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionArrayExtractor;
import base.components.expression.parsing.ExpressionAssumption;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class GenericTypesSelectorsExtractor extends ExpressionArrayExtractor {

    public GenericTypesSelectorsExtractor() {
        super(List.of(
                expression -> {
                    List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
                    if (scopes.isEmpty()) return true;
                    if(scopes.size() != 1) return false;
                    return scopes.get(0).second != expression.length()-1;
                }
        ), List.of(""));
    }

    @Override
    protected List<String> extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");

        //scopes is not empty in case of fallback expression
        if (scopes.isEmpty()) return List.of();

        expression = expression.substring(scopes.get(0).first + "<".length(), scopes.get(0).second).trim();

        List<Pair<Integer, Integer>> nestedSscopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, nestedSscopes, ",");

        //in case of fallback expression returns a single invalid expression
        return ParsingUtilities.indexSplit(expression, unscopedCommas).stream().map(String::trim).toList();
    }
}
