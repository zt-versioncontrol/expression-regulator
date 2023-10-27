package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class FieldTypeExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedEqual = SearchingUtilities.unscopedIndecisOf(expression, scopes, "=");

        if (!unscopedEqual.isEmpty()){
            expression = expression.substring(0, unscopedEqual.get(0)).trim();
        }

        List<Integer> unscopedSpaces = SearchingUtilities.unscopedIndecisOf(expression, scopes, " ");
        List<String> splits = ParsingUtilities.indexSplit(expression, unscopedSpaces);
        //type is not provided, invalid expression
        if (splits.size() < 2) return "";

        //if field type includes generics
        if (splits.size() >= 3 && splits.get(splits.size()-2).startsWith("<")){
            return splits.get(splits.size() - 3) + splits.get(splits.size() -2);
        }

        return splits.get(splits.size()-2);

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
