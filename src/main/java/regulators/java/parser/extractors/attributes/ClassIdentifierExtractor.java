package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;

import java.util.List;


public class ClassIdentifierExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<String> splits = List.of(expression.split("\\s"));
        int classIndex = splits.indexOf("class");
        if (classIndex != -1){
            if (splits.size() > classIndex+1) return splits.get(classIndex+1);
        }

        return "";
    }

    @Override
    protected String normalize(String expression) {
        expression = ManipulationUtilities.cutAfter(expression, "{", true);
        expression = expression.replaceAll("<", " <");
        expression = expression.replaceAll(">", "> ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");

        return expression.trim();
    }
}
