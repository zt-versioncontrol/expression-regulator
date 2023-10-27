package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.members.*;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.parsedObjects.types.ENum;
import regulators.java.parser.parsedObjects.types.INterface;
import utility.string.ManipulationUtilities;

public class EnumMemberProvider implements InstanceProvider {
    @Override
    public EnumMember provide(String expression) {
        //this procedure must always produce correct result given a valid expression
        //otherwise it may produce incorrect results but invalidations are caught later during extraction
        expression = ManipulationUtilities.foldScopes(expression, "{", "}", " {} ");
        expression = ManipulationUtilities.foldScopes(expression, "(", ")", " () ");
        expression = ManipulationUtilities.foldScopes(expression, "<", ">", " <> ");
        expression = ManipulationUtilities.foldScopes(expression, "\"", "\"", " \"\" ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");
        //for InitializationBlock
        expression = expression.trim();

        if (expression.startsWith("class ") || expression.contains(" class ")) return new CLass();
        if (expression.startsWith("interface ") || expression.contains(" interface ")) return new INterface();
        if (expression.startsWith("enum ") || expression.contains(" enum ")) return new ENum();
        if (expression.equals("static {}")) return new StaticBlock(expression);
        if (expression.equals("{}")) return new InitializationBlock(expression);

        if (!expression.contains("=") && expression.contains("()")) return new MEthod();

        return new FIeld();
    }
}
