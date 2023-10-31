package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;

public class SelectedTypeIdentifierExtractor extends ExpressionExtractor {

    public SelectedTypeIdentifierExtractor() {
        super(List.of(
                expression -> {
                    expression = expression.trim();
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
