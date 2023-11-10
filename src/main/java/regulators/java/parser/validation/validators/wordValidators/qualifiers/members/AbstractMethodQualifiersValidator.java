package regulators.java.parser.validation.validators.wordValidators.qualifiers.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.extractors.attributes.MethodQualifiersExtractor;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectors;

import java.util.List;
import java.util.Set;

public class AbstractMethodQualifiersValidator extends BasicExpressionValidator {

    Set<String> keywords = Set.of("public", "protected", "abstract");

    protected AbstractMethodQualifiersValidator() {
        super(ByConcreteTypeSelectors.AbstractMethodSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        List<Expression> qualifiers = expression.getDerivedExpressions().
                stream().filter(derived -> derived.getExtractorClass().equals(MethodQualifiersExtractor.class)).toList();

        for (Expression qualifier : qualifiers) {
            if (!keywords.contains(qualifier.getExpressionString())) return false;
        }

        return true;
    }
}
