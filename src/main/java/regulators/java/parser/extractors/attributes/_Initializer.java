package regulators.java.parser.extractors.attributes;

import base.components.expression.parsing.ExtractorType;

import java.util.Set;

public class _Initializer {
    public Set<ExtractorType> initialize(){
        return Set.of(
                new ClassIdentifierExtractor(),
                new ClassQualifiersExtractor(),
                new EnumIdentifierExtractor(),
                new EnumQualifiersExtractor(),
                new FieldIdentifierExtractor(),
                new FieldQualifiersExtractor(),
                new GenericTypeIdentifierExtractor(),
                new InterfaceIdentifierExtractor(),
                new InterfaceQualifiersExtractor(),
                new MethodIdentifierExtractor(),
                new MethodQualifiersExtractor(),
                new ParameterIdentifierExtractor()
        );
    }
}
