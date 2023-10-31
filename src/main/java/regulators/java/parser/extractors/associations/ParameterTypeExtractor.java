package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import javax.swing.plaf.metal.MetalSplitPaneUI;
import java.util.List;

public class ParameterTypeExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        int lastSpace = expression.lastIndexOf(" ");
        if (lastSpace == -1) return expression;

        return expression.substring(0, lastSpace);
    }

    @Override
    protected String normalize(String expression) {
        expression = expression.replaceAll("<", " <");
        expression = expression.replaceAll(">", "> ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");

        return expression.trim();
    }
}
