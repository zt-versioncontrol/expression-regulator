package regulators.json.parser.validation.selectors;

import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.parser.extractors.PropertyNameExtractor;

public class PropertyNameExpressionSelector extends ByExtractor {

    public PropertyNameExpressionSelector(){
        super(PropertyNameExtractor.class);
    }
}
