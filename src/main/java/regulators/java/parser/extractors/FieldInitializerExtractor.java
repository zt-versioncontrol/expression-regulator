package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class FieldInitializerExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");
        List<Integer> unscopedEqual = SearchingUtilities.unscopedIndecisOf(expression, scopes, "=");

        //no initializer
        if (unscopedEqual.isEmpty()) return "";

        //exclude semicolon
        expression = expression.substring(unscopedEqual.get(0)+1, expression.length()-1).trim();

        //return invalid expression if blank
        if (expression.isBlank()) return "=";

        return expression;
    }
}
