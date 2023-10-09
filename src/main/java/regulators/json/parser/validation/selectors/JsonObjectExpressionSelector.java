package regulators.json.parser.validation.selectors;

import base.expressions.validation.selectors.simple.HasDerivedByExtractor;
import base.parsing._ConcreteTypeExtractor;
import regulators.json.parser.parsedObjects.JsonObject;

public class JsonObjectExpressionSelector extends HasDerivedByExtractor.WithMatcher{
    protected JsonObjectExpressionSelector() {
        super(_ConcreteTypeExtractor.class, string -> string.equals(JsonObject.class.getTypeName()));
    }
}
