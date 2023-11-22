package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;

import java.util.List;

public class RangesExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        if (!expression.startsWith("[") || !expression.endsWith("]")) return List.of("");
        expression = expression.substring(1, expression.length() - 1);

        List<Integer> commas = SearchingUtilities.indicesOf(expression, ",");

        return ParsingUtilities.indexSplit(expression, commas).stream().map(String::trim).toList();
    }
}
