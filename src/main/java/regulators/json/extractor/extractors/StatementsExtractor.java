package regulators.json.extractor.extractors;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ManipulationUtilities;
import utility.string.SearchingUtilities;

import java.util.ArrayList;
import java.util.List;

public class StatementsExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        List<Integer> semiColons = SearchingUtilities.indicesOf(expression, ";");

        List<String> statements = new ArrayList<>();
        int start = 0;
        for (Integer semiColon : semiColons) {
            statements.add(expression.substring(start, semiColon));
        }
        if (start != expression.length()-1) statements.add(expression.substring(start));

        return statements;
    }

    @Override
    protected String normalize(String expression) {
        expression = expression.trim();
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");

        return expression;
    }
}
