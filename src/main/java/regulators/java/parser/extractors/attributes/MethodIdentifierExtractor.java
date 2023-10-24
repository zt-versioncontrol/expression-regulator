package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;

import java.util.List;

public class MethodIdentifierExtractor extends ExpressionExtractor {

    public MethodIdentifierExtractor() {
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
        List<String> splits = List.of(expression.split("\\s"));

        if (splits.isEmpty()) return "";
        return splits.get(splits.size()-1);
    }

    @Override
    protected String normalize(String expression) {
        expression = ManipulationUtilities.cutAfter(expression, "(", true);

        return expression.trim();
    }
}
