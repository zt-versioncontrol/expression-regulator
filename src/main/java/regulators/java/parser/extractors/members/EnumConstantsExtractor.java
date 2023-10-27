package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.Arrays;
import java.util.List;

public class EnumConstantsExtractor extends ExpressionArrayExtractor {

    public EnumConstantsExtractor() {
        super(List.of(
                expression -> {
                    List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");
                    if (scopes.size() != 1) return false;
                    return scopes.get(0).second.equals(expression.length() - 1);
                }
        ), List.of(""));
    }

    @Override
    protected List<String> extract(String expression) {

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "{", "}");
        expression = expression.substring(scopes.get(0).first + "{".length(), scopes.get(0).second);

        int firstSemiclon = expression.indexOf(";");

        expression = expression.substring(0, firstSemiclon == -1 ? expression.length() : firstSemiclon);

        return Arrays.stream(expression.split(",")).map(String::trim).toList();
    }
}
