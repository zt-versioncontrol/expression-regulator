package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionArrayExtractor;
import base.components.expression.parsing.ExpressionAssumption;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class GenericTypesExtractor extends ExpressionArrayExtractor {

    public GenericTypesExtractor() {
        super(List.of(expression -> expression.startsWith("<")&&expression.endsWith(">"),
                        expression -> expression.length() > 2 && !expression.substring(1, expression.length()-1).isBlank()),
                List.of(""));
    }

    @Override
    protected List<String> extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedCommas = SearchingUtilities.unscopedIndecisOf(expression, scopes, ",");

        return ParsingUtilities.indexSplit(expression, unscopedCommas).stream().map(String::trim).toList();
    }

    @Override
    protected String normalize(String expression) {
        return expression.substring(1, expression.length()-1);
    }
}
