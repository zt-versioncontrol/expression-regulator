package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;

public class SelectorIdentifierExtractor extends ExpressionExtractor {

    public SelectorIdentifierExtractor() {
        super(List.of(
                expression -> {
                    List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
                    if (scopes.size() == 0) return true;
                    if (scopes.size() > 1) return false;
                    return scopes.get(0).second == -1 || scopes.get(0).second.equals(expression.length()-1);
                }
        ), "");
    }

    @Override
    protected String extract(String expression) {
        return ManipulationUtilities.foldScopes(expression, "<", ">", "").trim();
    }
}
