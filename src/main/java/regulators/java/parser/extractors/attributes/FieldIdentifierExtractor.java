package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class FieldIdentifierExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedEqual = SearchingUtilities.unscopedIndecisOf(expression, scopes, "=");

        if (!unscopedEqual.isEmpty()){
            expression = expression.substring(0, unscopedEqual.get(0)).trim();
        }

        List<String> splits = List.of(expression.split("\\s"));
        return splits.get(splits.size()-1);
    }

    @Override
    protected String normalize(String expression) {
        expression = expression.replaceAll("<", " <");
        expression = expression.replaceAll(">", "> ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");
        //remove semisolon
        expression = expression.substring(0, expression.length()-1);

        return expression.trim();
    }
}
