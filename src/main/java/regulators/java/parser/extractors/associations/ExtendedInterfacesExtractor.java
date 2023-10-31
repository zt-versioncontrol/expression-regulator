package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class ExtendedInterfacesExtractor extends ExpressionExtractor {

    @Override
    protected String extract(String expression) {

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedExtends = SearchingUtilities.unscopedIndecisOf(expression, scopes, " extends ");

        if (unscopedExtends.isEmpty()) return "";

        return expression.substring(unscopedExtends.get(0)).trim();
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
