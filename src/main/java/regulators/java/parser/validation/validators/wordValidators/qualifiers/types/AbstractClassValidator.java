package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.extractors.attributes.ClassQualifiersExtractor;
import regulators.java.parser.validation.selectors.aggregate.AbstractMethodInClassSelector;

import java.util.List;

public class AbstractClassValidator extends BasicExpressionValidator {

    protected AbstractClassValidator() {
        super(AbstractMethodInClassSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
       Expression containingClass = expression.getOriginalExpression();

       List<Expression> classQualifiers = containingClass.getDerivedExpressions().stream().
                       filter(derived -> derived.getExtractorClass().equals(ClassQualifiersExtractor.class)).toList();

       return classQualifiers.stream().anyMatch(qualifier -> qualifier.getExpressionString().equals("abstract"));
    }
}
