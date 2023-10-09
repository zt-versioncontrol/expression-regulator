package regulators.json.parser.validation.selectors;

import base.expressions.validation.selectors.simple.HasDerivedByExtractor;
import base.parsing._ConcreteTypeExtractor;
import regulators.json.parser.parsedObjects.JsonNull;

public class JsonNullExpressionSelector extends HasDerivedByExtractor.WithMatcher {

    public JsonNullExpressionSelector(){
        super(_ConcreteTypeExtractor.class, string -> string.equals(JsonNull.class.getTypeName()));
    }
}
