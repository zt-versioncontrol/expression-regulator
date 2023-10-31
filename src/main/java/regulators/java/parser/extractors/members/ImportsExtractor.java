package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExpressionArrayExtractor;
import utility.string.ParsingUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportsExtractor extends ExpressionArrayExtractor {
    @Override
    protected List<String> extract(String expression) {
        //remove type definitions
        int firstScope = expression.indexOf("{");
        if (firstScope != -1){
            int lastSemicolon = expression.lastIndexOf(';', firstScope);
            if (lastSemicolon == -1) return List.of();
            expression = expression.substring(0, lastSemicolon + 1);
        }

        //remove package
        if (expression.startsWith("package ")){
            int firstSemicolon = expression.indexOf(';');
            if (firstSemicolon == -1) return List.of();
            expression = expression.substring(firstSemicolon+1);
        }

        expression = expression.trim();
        if (expression.isEmpty()) return List.of();

        List<String> splits = List.of(expression.split(";"));


        //restore semicolons. last split might not be terminated by semicolon
        List<String> imports = new ArrayList<>(splits.subList(0, splits.size()-1).stream().map(s -> s + ";").toList());
        if (expression.endsWith(";")) imports.add(splits.get(splits.size()-1) + ";");
        else imports.add(splits.get(splits.size()-1));

        return imports.stream().map(String::trim).toList();
    }
}
