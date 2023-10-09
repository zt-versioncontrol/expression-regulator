package regulators.json.parser.validation.selectors;

import base.components.expression.validation.BasicExpressionSelector;

import java.util.Set;

public class SelectorsInitializer {
    public Set<BasicExpressionSelector> provide(){
        return Set.of(
                new BinaryExpressionSelector(),
                new JsonArrayExpressionSelector(),
                new JsonInvalidExpressionSelector(),
                new JsonNullExpressionSelector(),
                new JsonObjectExpressionSelector(),
                new JsonStringExpressionSelector(),
                new NumberExpressionSelector(),
                new PropertyExpressionSelector(),
                new PropertyNameExpressionSelector()
        );
    }
}
