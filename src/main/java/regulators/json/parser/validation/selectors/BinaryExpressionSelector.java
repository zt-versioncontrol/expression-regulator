package regulators.json.parser.validation.selectors;

import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import base.expressions.validation.selectors.simple.HasDerivedByExtractor;
import base.components.expression.validation.BasicExpressionSelector;
import base.parsing._ConcreteTypeExtractor;
import regulators.json.parser.extractors.BinaryValueExtractor;
import regulators.json.parser.parsedObjects.JsonBinary;

public class BinaryExpressionSelector implements BasicExpressionSelector {
    @Override
    public boolean isSelected(Expression expression) {
        ByExtractor binaryValueSelector = new ByExtractor(BinaryValueExtractor.class) {};
        HasDerivedByExtractor.WithMatcher JsonBinarySelector = new HasDerivedByExtractor.WithMatcher(
                _ConcreteTypeExtractor.class, string -> string.equals(JsonBinary.class.getTypeName())) {};

        return binaryValueSelector.isSelected(expression) || JsonBinarySelector.isSelected(expression);
    }
}
