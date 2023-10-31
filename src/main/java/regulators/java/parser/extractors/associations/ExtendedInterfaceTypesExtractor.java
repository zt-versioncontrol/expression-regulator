package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class ExtendedInterfaceTypesExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        if (!expression.startsWith("extends ")) return List.of("");

        expression = expression.substring("extends ".length());

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, scopes, ",");

        return ParsingUtilities.indexSplit(expression, unscopedCommas).stream().map(String::trim).toList();
    }
}
