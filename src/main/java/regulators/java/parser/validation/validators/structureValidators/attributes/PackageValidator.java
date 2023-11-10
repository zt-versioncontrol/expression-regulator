package regulators.java.parser.validation.validators.structureValidators.attributes;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByExtractorSelectors;

public class PackageValidator extends BasicExpressionValidator {
    protected PackageValidator() {
        super(ByExtractorSelectors.PackageSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        String expressionString = expression.getExpressionString();
        if (expressionString.isEmpty()) return true;
        return expressionString.startsWith("package ") && expressionString.endsWith(";");
    }
}
