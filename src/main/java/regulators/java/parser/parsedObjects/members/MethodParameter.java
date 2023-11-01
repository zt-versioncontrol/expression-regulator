package regulators.java.parser.parsedObjects.members;

import base.parsing.StringConstructed;
import regulators.java.parser.extractors.attributes.ParameterIdentifierExtractor;
import regulators.java.parser.extractors.associations.ParameterTypeExtractor;
import regulators.java.parser.parsedObjects.associations.TypeSelector;

public class MethodParameter {

    public MethodParameter(String expression){}

    @StringConstructed(extractor = ParameterIdentifierExtractor.class)
    private String identifier;

    @StringConstructed(extractor = ParameterTypeExtractor.class)
    private TypeSelector type;
}
