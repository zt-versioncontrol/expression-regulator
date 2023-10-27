package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;
import java.util.stream.Stream;

public class MethodExceptionsExtractor extends ExpressionArrayExtractor {

    public MethodExceptionsExtractor() {
        super(List.of(
                expression -> {
                    //must have parameters
                    //parameters scope must be before definition scope
                    if (!expression.contains("(")) return false;
                    if (!expression.contains("{")) return true;
                    return expression.indexOf("(") < expression.indexOf("{");
                },
                expression -> {
                    List<Pair<Integer,Integer>> scopes =  ParsingUtilities.scopeBoundaries(expression, "(", ")");
                    return scopes.size() > 0 && scopes.get(0).second != -1;
                }
                ),
                List.of());
    }

    @Override
    protected List<String> extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "(", ")");
        expression = expression.substring(scopes.get(0).second + ")".length());
        expression = expression.trim();

        if (expression.contains("{")) expression = expression.substring(0, expression.indexOf("{"));
        //remove terminating semiclon from abstract method
        else expression = expression.substring(0, expression.length()-1);

        //invalid expression
        if (!expression.startsWith("throws ")) return List.of("");

        expression = ManipulationUtilities.cutBefore(expression, "throws ", true).trim();

        return Stream.of(expression.split(",")).map(String::trim).toList();
    }
}
