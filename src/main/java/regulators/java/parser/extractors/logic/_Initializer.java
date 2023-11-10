package regulators.java.parser.extractors.logic;

import base.components.expression.parsing.ExtractorType;

import java.util.Set;

public class _Initializer {
    public Set<ExtractorType> initialize(){
        return Set.of(
                new FieldInitializerExtractor(),
                new StatementsExtractor()
        );
    }
}
