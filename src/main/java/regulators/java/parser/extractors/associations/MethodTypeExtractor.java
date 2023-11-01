package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class MethodTypeExtractor extends ExpressionExtractor {

    public MethodTypeExtractor() {
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
        List<Pair<Integer, Integer>> scopes =ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedSpaces = SearchingUtilities.unscopedIndecisOf(expression, scopes, " ");
        List<String> splits = ParsingUtilities.indexSplit(expression, unscopedSpaces);

        if (splits.size() < 2) return "";

        //method type is second from end or second and third from end concatenated if type included generic type specifiers
        if (splits.size() >= 3 &&splits.get(splits.size()-2).startsWith("<")){
            return splits.get(splits.size()-3) + splits.get(splits.size()-2);
        }else{
            return splits.get(splits.size()-2);
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
