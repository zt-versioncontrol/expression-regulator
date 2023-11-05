package regulators.java.parser.validation.validators.structureValidators.associations;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByExtractorSelectors;

public class ImportValidator extends BasicExpressionValidator {
    protected ImportValidator() {
        super(ByExtractorSelectors.ImportSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();
        boolean isValid = expressionString.startsWith("import ") && expressionString.endsWith(";");

        if (isValid && expressionString.contains("*")){
            //remove semicolon the remove blanks
            String trimmemed = expressionString.substring(0, expressionString.length()-1).trim();

            //the character "*" is only allowed once, at the end
            trimmemed = trimmemed.substring(0, trimmemed.length()-1);
            if (trimmemed.contains("*")) return false;
        }

        return isValid;
    }
}
