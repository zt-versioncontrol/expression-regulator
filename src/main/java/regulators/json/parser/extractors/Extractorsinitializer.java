package regulators.json.parser.extractors;

import base.components.expression.parsing.ExtractorType;

import java.util.List;
import java.util.Set;

public class Extractorsinitializer {
    public Set<ExtractorType> provide(){
        return Set.of(
                new BinaryValueExtractor(),
                new JsonArrayElementsExtractor(),
                new JsonExtractor(),
                new NumberValueExtractor(),
                new PropertiesExtractor(),
                new PropertyNameExtractor(),
                new PropertyValueExtractor(),
                new StringValueExtractor()
        );
    }
}
