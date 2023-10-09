package regulators.json.parser.validation.selectors;

import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.parser.extractors.PropertiesExtractor;

public class PropertyExpressionSelector extends ByExtractor {

    public PropertyExpressionSelector(){
        super(PropertiesExtractor.class);
    }
}
