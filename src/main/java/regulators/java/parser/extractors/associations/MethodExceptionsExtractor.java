package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

public class MethodExceptionsExtractor extends ExpressionArrayExtractor {

    public MethodExceptionsExtractor() {
        super(List.of(
                expression -> {
                    List<Pair<Integer,Integer>> scopes =
                            ParsingUtilities.noneIntersectedScopeBoundaries(expression, List.of(new Pair<>("(", ")"), new Pair<>("{", "}")), List.of());
                    //must have parameters scope
                    if (scopes.isEmpty()) return false;
                    if (expression.charAt(scopes.get(0).first) != '(') return false;
                    //parameters scope must be bound
                    if (scopes.get(0).second == -1) return false;

                    //if abstract method it must end with ';'
                    if (scopes.size() == 1){
                        return expression.endsWith(";");
                    }

                    //must contain only one parameters scope
                    for (Pair<Integer, Integer> bounds : scopes.subList(1, scopes.size())) {
                        if (expression.charAt(bounds.first) == '(') {
                            return false;
                        }
                    }
                    return true;
                }),
                List.of(""));
    }

    @Override
    protected List<String> extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "(", ")");
        expression = expression.substring(scopes.get(0).second + ")".length());
        expression = expression.trim();

        if (expression.contains("{")) expression = expression.substring(0, expression.indexOf("{")).trim();
        //remove terminating semiclon from abstract method
        else expression = expression.substring(0, expression.length()-1).trim();

        if (expression.isBlank()) return List.of();

        //invalid expression
        if (!expression.startsWith("throws ")) return List.of("");

        expression = ManipulationUtilities.cutBefore(expression, "throws ", true).trim();

        return Stream.of(expression.split(",")).map(String::trim).toList();
    }
}
