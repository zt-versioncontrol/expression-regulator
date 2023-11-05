package regulators.java.parser.validation.validators.wordValidators.qualifiers.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.extractors.attributes.MethodQualifiersExtractor;
import regulators.java.parser.validation.selectors.aggregate.AbstractMethodInClassSelector;

import java.util.List;

public class AbstractMethodInClassQualifiersValidator extends BasicExpressionValidator {

    protected AbstractMethodInClassQualifiersValidator() {
        super(AbstractMethodInClassSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        List<Expression> qualifiers = expression.getDerivedExpressions().
                stream().filter(derived -> derived.getExtractorClass().equals(MethodQualifiersExtractor.class)).toList();

        return qualifiers.stream().anyMatch(qualifier-> qualifier.getExpressionString().equals("abstract"));
    }
}
