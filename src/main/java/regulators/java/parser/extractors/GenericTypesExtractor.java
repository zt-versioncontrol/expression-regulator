package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class GenericTypesExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, ">", ">");
        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, scopes, ",");

        return ParsingUtilities.indexSplit(expression, unscopedCommas).stream().map(String::trim).toList();
    }

    @Override
    protected String normalize(String expression) {
        if (expression.length() < 2) return "";
        return expression.substring(1, expression.length()-1);
    }
}
