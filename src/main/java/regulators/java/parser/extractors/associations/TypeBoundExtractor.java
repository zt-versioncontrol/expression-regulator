package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;

public class TypeBoundExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int extendsIndex = expression.indexOf(" extends ");
        if (extendsIndex == -1) return "";

        return expression.substring(extendsIndex+" extends ".length()).trim();
    }

    @Override
    protected String normalize(String expression) {
        return ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ").trim();
    }
}
