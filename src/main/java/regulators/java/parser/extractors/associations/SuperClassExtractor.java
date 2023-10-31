package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class SuperClassExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedExtends = SearchingUtilities.unscopedIndecisOf(expression, scopes, " extends ");
        List<Integer> unscopedImplements = SearchingUtilities.unscopedIndecisOf(expression, scopes, " implements ");

        Integer firstExtends = unscopedExtends.isEmpty()? null : unscopedExtends.get(0);
        Integer firstImplements = unscopedImplements.isEmpty()? null: unscopedImplements.get(0);

        if (firstExtends == null) return "";
        if (firstImplements != null && firstExtends > firstImplements) return "";

        int end = firstImplements == null? expression.length() : firstImplements;

        return expression.substring(firstExtends, end).trim();
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
