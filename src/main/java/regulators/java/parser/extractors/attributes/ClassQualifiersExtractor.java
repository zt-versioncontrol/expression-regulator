package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ManipulationUtilities;

import java.util.List;


public class ClassQualifiersExtractor extends ExpressionArrayExtractor {

    @Override
    protected List<String> extract(String expression) {
        List<String> splits = List.of(expression.split("\\s"));
        int classIndex = splits.indexOf("class");
        if (classIndex != -1){
            return splits.subList(0, classIndex);
        }

        return List.of();
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
