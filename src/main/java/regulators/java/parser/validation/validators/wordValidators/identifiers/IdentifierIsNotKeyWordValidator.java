package regulators.java.parser.validation.validators.wordValidators.identifiers;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.IdentifierSelector;

import java.util.Set;

public class IdentifierIsNotKeyWordValidator extends BasicExpressionValidator {

    // TODO: 11/2/2023 add missing keywords
    private final Set<String> keywords = Set.of("class", "interface", "enum",
            "extends", "implements",
            "import", "package",
            "public", "private", "protected", "static", "final",
            "if", "else", "for", "do", "while",
            "return", "true", "false", "new");

    protected IdentifierIsNotKeyWordValidator() {
        super(IdentifierSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return !keywords.contains(expression.getExpressionString());
    }
}
