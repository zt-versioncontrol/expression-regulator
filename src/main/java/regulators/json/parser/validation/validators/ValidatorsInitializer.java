package regulators.json.parser.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;

import java.util.Set;

public class ValidatorsInitializer {
    public Set<BasicExpressionValidator> provide(){
        return Set.of(
                new JsonArrayValidator(),
                new JsonBinaryValidator(),
                new JsonInvalidValidator(),
                new JsonNullValidator(),
                new JsonNumberValidator(),
                new JsonObjectValidator(),
                new JsonStringValidator(),
                new PropertyNameValidator(),
                new PropertyValidator()
        );
    }
}
