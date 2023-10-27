package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class InterfaceGenericsExtractor extends ExpressionExtractor {

    @Override
    protected String extract(String expression) {
        List<String> splits = List.of(expression.split("\\s"));
        int interfaceIndex = splits.indexOf("interface");
        //interface is first, then identifier, then generics (if generics is present)
        if (interfaceIndex == -1 || splits.size() < interfaceIndex+2+1) return "";

        //remove identifier and every character before it
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = interfaceIndex+2; i < splits.size()-1; i++) {
            stringBuilder.append(splits.get(i));
            stringBuilder.append(" ");
        }
        stringBuilder.append(splits.get(splits.size()-1));
        String afterIdentifier = stringBuilder.toString();

        //generics end when unscoped " extends " is encountered, or at the end of expression
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(afterIdentifier, "<", ">");
        List<Integer> unscopedExtends = SearchingUtilities.unscopedIndecisOf(afterIdentifier, scopes, " extends ");

        int end = afterIdentifier.length();

        if (unscopedExtends.size() != 0) end = unscopedExtends.get(0);

        return afterIdentifier.substring(0, end);
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
