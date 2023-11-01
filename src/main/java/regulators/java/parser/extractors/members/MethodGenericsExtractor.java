package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class MethodGenericsExtractor extends ExpressionExtractor {

    public MethodGenericsExtractor() {
        super(List.of(
                expression -> {
                    //must have parameters
                    //parameters scope must be before definition scope
                    if (!expression.contains("(")) return false;
                    if (!expression.contains("{")) return true;
                    return expression.indexOf("(") < expression.indexOf("{");
                }
        ), "");
    }


    @Override
    protected String extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedSpaces = SearchingUtilities.unscopedIndecisOf(expression, scopes, " ");

        List<String> splits = ParsingUtilities.indexSplit(expression, unscopedSpaces);

        if (splits.size() < 3) return "";

        //if method type includes generics
        if (splits.get(splits.size() - 2).startsWith("<")){
            if (splits.size() < 4) return "";
            if (splits.get(splits.size() - 4).startsWith("<")) return splits.get(splits.size() - 4);
            return "";

        }else {
            if (splits.get(splits.size() - 3).startsWith("<")) return splits.get(splits.size() -3);
            return "";
        }
    }

    @Override
    protected String normalize(String expression) {
        expression = ManipulationUtilities.cutAfter(expression, "(", true);
        expression = expression.replaceAll("<", " <");
        expression = expression.replaceAll(">", "> ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");

        return expression.trim();
    }
}
