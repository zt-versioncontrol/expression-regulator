package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ManipulationUtilities;

import java.util.List;

public class EnumQualifiersExtractor extends ExpressionArrayExtractor {

    @Override
    protected List<String> extract(String expression) {
        List<String> splits = List.of(expression.split("\\s"));
        int enumIndex = splits.indexOf("enum");
        if (enumIndex != -1){
            return splits.subList(0, enumIndex);
        }

        return List.of();
    }

    @Override
    protected String normalize(String expression) {
        expression = ManipulationUtilities.cutAfter(expression, "{", true);
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");
        return expression.trim();
    }
}
