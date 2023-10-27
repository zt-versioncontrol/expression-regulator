package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class MethodQualifiersExtractor extends ExpressionArrayExtractor {

    public MethodQualifiersExtractor() {
        super(List.of(
                expression -> {
                    //must have parameters
                    //parameters scope must be before definition scope
                    if (!expression.contains("(")) return false;
                    if (!expression.contains("{")) return true;
                    return expression.indexOf("(") < expression.indexOf("{");
                }
        ), List.of());
    }

    @Override
    protected List<String> extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedSpaces = SearchingUtilities.unscopedIndecisOf(expression, scopes, " ");

        List<String> splits = ParsingUtilities.indexSplit(expression, unscopedSpaces);

        //contains only identifier and method type
        if (splits.size() < 3) return List.of();

        //method type or generic specifier of method type
        int end = splits.size() - 2;

        //if generic specifier of method type
        if (splits.get(end).startsWith("<")){
            //generic types of method, last qualifier or neither
            end = end-2;
            //if generic types of method or last qualifier
            if (end >= 0){
                //if not generic types of method
                if (!splits.get(end).startsWith("<")) end = end + 1;
            }
        } else{  //else, it is method type
            end = end-1;
            //if not generic types of method
            if (!splits.get(end).startsWith("<")) end = end +1;
        }


        if (end < 0) return List.of();
        return splits.subList(0, end);
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
