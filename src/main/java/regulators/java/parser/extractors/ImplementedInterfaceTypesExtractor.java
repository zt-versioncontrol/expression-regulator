package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class ImplementedInterfaceTypesExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        if (!expression.startsWith("implements ")) return List.of("");

        expression = expression.substring("implements ".length());

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, scopes, ",");

        return ParsingUtilities.indexSplit(expression, unscopedCommas).stream().map(String::trim).toList();
    }
}
