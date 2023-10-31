package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;

import java.util.List;

public class EnumImplementedInterfacesExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<String> splits = List.of(expression.split("\\s"));
        Integer enumIndex = splits.indexOf("enum");
        if (enumIndex == -1 || splits.size() <= enumIndex +2){
            return "";
        }

        //after enum identifier
        StringBuilder implementedInterfacesBuilder = new StringBuilder();
        for (int i = enumIndex+2; i < splits.size()-1; i++) {
            implementedInterfacesBuilder.append(splits.get(i)).append(" ");
        }
        implementedInterfacesBuilder.append(splits.get(splits.size()-1));

        return implementedInterfacesBuilder.toString();
    }

    @Override
    protected String normalize(String expression) {
        expression = ManipulationUtilities.cutAfter(expression, "{", true);
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");
        return expression.trim();
    }
}
