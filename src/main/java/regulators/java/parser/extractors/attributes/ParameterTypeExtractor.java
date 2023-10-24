package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExpressionExtractor;
import utility.string.ParsingUtilities;
import utility.structure.Pair;

import javax.swing.plaf.metal.MetalSplitPaneUI;
import java.util.List;

public class ParameterTypeExtractor extends ExpressionExtractor {
    @Override
    protected String extract(String expression) {
        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, "<", ">");

        if (scopes.isEmpty()){
            List<String> splits = List.of(expression.split("\\s"));
            //does not include parameter identifier
            if (splits.size() == 1) return expression;

            //reassemble the expression leaving the last split
            //if splits.size == 2 then expression is valid
            StringBuilder extracted = new StringBuilder();
            for (int i = 0; i < splits.size()-1; i++) {
                extracted.append(splits.get(i)).append(" ");
            }
            return extracted.toString().trim();
        }

        if (scopes.get(0).second == -1) return expression;
        //does not include parameter identifier
        if (scopes.get(0).second == expression.length()-1) return expression;

        //subtract parameter identifier from expression
        String afterScope = expression.substring(scopes.get(0).second + ">".length());
        List<String> splits = List.of(afterScope.split("\\s"));

        //valid expression case
        if (splits.size() == 1) return expression.substring(0, scopes.get(0).second);

        //invalid expression, reassemble afterScope leaving parameter identifier
        StringBuilder afterScopeReassembled = new StringBuilder();
        for (int i = 0; i < splits.size()-2; i++) {
            afterScopeReassembled.append(splits.get(i)).append(" ");
        }
        afterScopeReassembled.append(splits.get(splits.size()-2));
        return expression.substring(0, scopes.get(0).second+1) + afterScopeReassembled.toString().trim();

    }
}
