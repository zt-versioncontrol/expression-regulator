package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.ArrayList;
import java.util.List;

public class TypeDefinitionsFromFileExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        List<String> derivedExpressions = new ArrayList<>();

        List<Pair<Integer, Integer>> typeScopeBoundaries = ParsingUtilities.scopeBoundaries(expression, "{", "}");
        int nextExpressionStart = 0;
        //a scope and every unscoped character before it, until preceding scope end, are part of one expression
        for (Pair<Integer, Integer> scopeBoundaries : typeScopeBoundaries) {
            if (scopeBoundaries.second != -1){
                derivedExpressions.add(expression.substring(nextExpressionStart, scopeBoundaries.second+1).trim());
                nextExpressionStart = scopeBoundaries.second+1;
            }else{
                //if index of scope end indicator is -1 then scope is open and it is the last scope, according to definition of ParsingUtilities.scopeBoundaries
                //no need to update nextExpressionStart since this is the last iteration
                derivedExpressions.add(expression.substring(nextExpressionStart).trim());
            }
        }


        return derivedExpressions;
    }

    @Override
    protected String normalize(String expression) {
        expression = expression.trim();

        //remove package and imports
        int firstTypeDefinition = ParsingUtilities.firstScopeBoundaries(expression, "{", "}").first;
        if (firstTypeDefinition == -1) expression = "";
        else{
            int lastSemiColon = expression.substring(0, firstTypeDefinition).lastIndexOf(';');
            if (lastSemiColon != -1) expression = expression.substring(lastSemiColon+1).trim();
            else expression = expression.trim();
        }

        return expression;
    }
}
