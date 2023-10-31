package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;


public class GenericTypeIdentifierExtractor extends ExpressionExtractor {

    @Override
    protected String extract(String expression) {
        int extendsIndex = expression.indexOf(" extends ");
        if (extendsIndex == -1) return expression;
        return expression.substring(0, extendsIndex).trim();
    }

    @Override
    protected String normalize(String expression) {
        expression =expression.trim();
        return ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");
    }
}
