package regulators.java.parser.extractors;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;

import java.util.Arrays;
import java.util.List;

public class ImportsExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        return Arrays.stream(expression.split(";")).filter(String::isBlank).map(String::trim).toList();
    }



    @Override
    protected String normalize(String expression) {
        expression = expression.trim();

        //remove package statement
        if (expression.startsWith("package")){
            int semiclon = expression.indexOf(';');
            if (semiclon == -1) expression = "";
            else expression =  expression.substring(0, semiclon);
        }

        //remove type definitions (class, interface, enum)
        int typeDefinitionStart =  ParsingUtilities.firstScopeBoundaries(expression, "{", "}").first;
        if (typeDefinitionStart != -1) expression = expression.substring(0, typeDefinitionStart);

        //remove declaration of first type (public class MyClass<t>)
        int lastSemiColon = expression.lastIndexOf(';');
        if (lastSemiColon == -1) expression = "";
        else expression = expression.substring(0, lastSemiColon);

        return expression.trim();
    }
}
