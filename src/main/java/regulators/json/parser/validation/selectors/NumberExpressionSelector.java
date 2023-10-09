package regulators.json.parser.validation.selectors;

import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import base.expressions.validation.selectors.simple.HasDerivedByExtractor;
import base.components.expression.validation.BasicExpressionSelector;
import base.parsing._ConcreteTypeExtractor;
import regulators.json.parser.extractors.NumberValueExtractor;
import regulators.json.parser.parsedObjects.JsonNumber;

public class NumberExpressionSelector implements BasicExpressionSelector {
    @Override
    public boolean isSelected(Expression expression) {
        ByExtractor numberValueSelector = new ByExtractor(NumberValueExtractor.class) {};
        HasDerivedByExtractor.WithMatcher jsonNumberSelector = new HasDerivedByExtractor.WithMatcher(
                _ConcreteTypeExtractor.class, string -> string.equals(JsonNumber.class.getTypeName())) {};

        return numberValueSelector.isSelected(expression) || jsonNumberSelector.isSelected(expression);
    }
}
