package regulators.json.parser.validation.selectors;

import base.expressions.validation.selectors.simple.HasDerivedByExtractor;
import base.parsing._ConcreteTypeExtractor;
import regulators.json.parser.parsedObjects.JsonString;

public class JsonStringExpressionSelector extends HasDerivedByExtractor.WithMatcher {
    protected JsonStringExpressionSelector() {
        super(_ConcreteTypeExtractor.class, string -> string.equals(JsonString.class.getTypeName()));
    }
}
