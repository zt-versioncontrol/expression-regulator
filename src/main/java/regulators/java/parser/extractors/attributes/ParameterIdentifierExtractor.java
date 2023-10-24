package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;

public class ParameterIdentifierExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        if (scopes.isEmpty()){
            List<String> splits = List.of(expression.split("\\s"));
            if (splits.size() == 1) return "";
            return splits.get(splits.size()-1).trim();
        }

        if (scopes.get(0).second == -1) return "";
        return expression.substring(scopes.get(0).second + ">".length()).trim();
    }
}
