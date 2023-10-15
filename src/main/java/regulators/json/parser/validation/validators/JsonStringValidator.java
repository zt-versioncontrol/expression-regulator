package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.JsonStringExpressionSelector;
import utility.string.SearchingUtilities;

import java.util.List;

public class JsonStringValidator extends BasicExpressionValidator {

    public JsonStringValidator(){
        super(JsonStringExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        if (expressionString.length() < 2) return false;
        if(expressionString.charAt(0) != '"' || expressionString.charAt(expressionString.length()-1) != '"') return false;

        //embedded double quotes must be preceded by backslash character
        expressionString = expressionString.substring(1, expressionString.length()-1);
        List<Integer> doubleQuotes = SearchingUtilities.indicesOf(expressionString, "\"");
        for (Integer doubleQuote : doubleQuotes) {
            if (doubleQuote == 0) return false;
            if (expressionString.charAt(doubleQuote-1) != '\\') return false;
        }


        return true;
    }
}
