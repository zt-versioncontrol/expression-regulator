package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionArrayExtractor;
import base.components.expression.parsing.ExpressionAssumption;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class FieldQualifiersExtractor extends ExpressionArrayExtractor {

    public FieldQualifiersExtractor() {
        super(List.of(expression -> expression.endsWith(";")), List.of(""));
    }

    @Override
    protected List<String> extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedEqual = SearchingUtilities.unscopedIndecisOf(expression, scopes, "=");

        if (!unscopedEqual.isEmpty()){
            expression = expression.substring(0, unscopedEqual.get(0)).trim();
        }

        List<Integer> unscopedSpaces = SearchingUtilities.unscopedIndecisOf(expression, scopes, " ");
        List<String> splits = ParsingUtilities.indexSplit(expression, unscopedSpaces);

        if (splits.size() < 3) return List.of();

        //if field type contain generics
        if (splits.get(splits.size()-2).startsWith("<")){
            return splits.subList(0, splits.size()-3);
        }

        return splits.subList(0, splits.size()-2);
    }

    @Override
    protected String normalize(String expression) {
        expression = expression.replaceAll("<", " <");
        expression = expression.replaceAll(">", "> ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");
        //remove semicolon
        expression = expression.substring(0, expression.length()-1);

        return expression.trim();
    }
}
