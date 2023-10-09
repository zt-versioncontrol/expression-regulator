package regulators.json.parser.validation.selectors;

import base.expressions.validation.selectors.simple.HasDerivedByExtractor;
import base.parsing._ConcreteTypeExtractor;
import regulators.json.parser.parsedObjects.JsonInvalid;


public class JsonInvalidExpressionSelector extends HasDerivedByExtractor.WithMatcher {
    protected JsonInvalidExpressionSelector() {
        super(_ConcreteTypeExtractor.class, string -> string.equals(JsonInvalid.class.getTypeName()));
    }
}
