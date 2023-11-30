package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.CompositionSelctorSelector;

public class CompositionSelectorValidator extends BasicExpressionValidator {

    protected CompositionSelectorValidator() {
        super(CompositionSelctorSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().contains(" as ");
    }
}
