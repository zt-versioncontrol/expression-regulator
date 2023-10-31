package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class ImplementedInterfacesExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedImplements = SearchingUtilities.unscopedIndecisOf(expression, scopes, " implements ");

        if (unscopedImplements.isEmpty()) return "";

        return expression.substring(unscopedImplements.get(0)).trim();
    }

    @Override
    protected String normalize(String expression) {
        expression = ManipulationUtilities.cutAfter(expression, "{", true);
        expression = expression.replaceAll("<", " <");
        expression = expression.replaceAll(">", "> ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");
        expression = expression.trim();

        return expression;
    }
}
