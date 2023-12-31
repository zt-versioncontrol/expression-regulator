package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import java.util.List;

public class ParameterIdentifierExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int lastSpace = expression.lastIndexOf(" ");

        if (lastSpace == -1) return "";
        return expression.substring(lastSpace + " ".length());
    }

    @Override
    protected String normalize(String expression) {
        expression = expression.replaceAll("<", " <");
        expression = expression.replaceAll(">", "> ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");

        return expression.trim();
    }
}
