package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ManipulationUtilities;
import utility.string.ParsingUtilities;
import utility.string.SearchingUtilities;
import utility.structure.Pair;

import java.util.List;

public class ClassGenericsExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<String> splits = List.of(expression.split("\\s"));
        int classIndex = splits.indexOf("class");
        //class is first, then identifier, then generics (if generics is present)
        if (classIndex == -1 || splits.size() < classIndex+2+1) return "";

        //remove identifier and every character before it
        StringBuilder stringBuilder = new StringBuilder();
        //space character that comes after name is significant for finding " extends " or " implements "
        stringBuilder.append(" ");
        for (int i = classIndex+2; i < splits.size()-1; i++) {
            stringBuilder.append(splits.get(i));
            stringBuilder.append(" ");
        }
        stringBuilder.append(splits.get(splits.size()-1));
        String afterIdentifier = stringBuilder.toString();

        //generics end when unscoped "extends" or "implements" is encountered, whichever one comes first. Otherwise generics ends at the end of expression
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(afterIdentifier, "<", ">");
        List<Integer> unscopedExtends = SearchingUtilities.unscopedIndecisOf(afterIdentifier, scopes, " extends ");
        List<Integer> unscopedImplements = SearchingUtilities.unscopedIndecisOf(afterIdentifier, scopes, " implements ");

        int end = afterIdentifier.length();

        if (unscopedExtends.size() != 0) end = unscopedExtends.get(0);
        if (unscopedImplements.size() != 0) end = end < unscopedImplements.get(0)? end : unscopedImplements.get(0);

        return afterIdentifier.substring(0, end).trim();
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
