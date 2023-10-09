package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import base.components.expression.validation.BasicExpressionValidator;
import regulators.json.parser.validation.selectors.PropertyNameExpressionSelector;

public class PropertyNameValidator extends BasicExpressionValidator {

    public PropertyNameValidator(){
        super(PropertyNameExpressionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();

        if (expressionString.isBlank()) return false;
        if (!(isAlphabet(expressionString.charAt(0)) || expressionString.charAt(0)=='$' || expressionString.charAt(0)=='_')) return false;

        for (int i = 0; i < expressionString.length(); i++) {
            char c = expressionString.charAt(i);

            if (!(isDigit(c) || isAlphabet(c) || c == '$' || c =='_'))return false;
        }

        return true;
    }

    private boolean isDigit(char c){
        return c =='0'||
                c=='1'||
                c=='2'||
                c=='3'||
                c=='4'||
                c=='5'||
                c=='6'||
                c=='7'||
                c=='8'||
                c=='9';
    }

    private boolean isAlphabet(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
