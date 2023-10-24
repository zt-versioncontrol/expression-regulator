package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.members.*;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.parsedObjects.types.ENum;
import regulators.java.parser.parsedObjects.types.INterface;
import utility.string.ManipulationUtilities;

public class ClassMemberProvider implements InstanceProvider {
    @Override
    public Object provide(String expression) {
        expression = ManipulationUtilities.foldScopes(expression, "{", "}", " {} ");
        expression = ManipulationUtilities.foldScopes(expression, "(", ")", " () ");
        expression = ManipulationUtilities.foldScopes(expression, "<", ">", " <> ");
        expression = ManipulationUtilities.foldScopes(expression, "\"", "\"", " \"\" ");
        expression = ManipulationUtilities.foldCharacters(expression, Character::isWhitespace, " ");

        if (expression.startsWith("class ") || expression.contains(" class ")) return new CLass();
        if (expression.startsWith("interface ") || expression.contains(" interface ")) return new INterface();
        if (expression.startsWith("enum ") || expression.contains(" enum ")) return new ENum();
        if (expression.equals("static: {}")) return new StaticBlock();
        if (expression.equals("{}")) return new InitializationBlock();

        if (!expression.contains("=") && expression.contains("()")){
            int parametersScope = expression.indexOf("()");
            int methodScope = expression.indexOf("{}");

            if (methodScope == -1 || methodScope < parametersScope) return new AbstractMethod();
            return new MEthod();
        }

        return new FIeld();
    }
}
