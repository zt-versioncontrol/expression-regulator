package regulators.json.parser.validation.selectors;

import base.expressions.validation.selectors.simple.HasDerivedByExtractor;
import base.parsing._ConcreteTypeExtractor;
import regulators.json.parser.parsedObjects.JsonArray;

public class JsonArrayExpressionSelector extends HasDerivedByExtractor.WithMatcher {
    protected JsonArrayExpressionSelector() {
        super(_ConcreteTypeExtractor.class, string -> string.equals(JsonArray.class.getTypeName()));
    }
}
