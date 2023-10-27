package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;

import java.util.List;

public class EnumIdentifierExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<String> splits = List.of(expression.split("\\s"));
        int enumIndex = splits.indexOf("enum");
        if (enumIndex != -1){
            if (splits.size() > enumIndex+1) return splits.get(enumIndex+1);
        }

        return "";
    }

    @Override
    protected String normalize(String expression) {
        expression = ManipulationUtilities.cutAfter(expression, "{", true);
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");

        return expression.trim();
    }
}
