package regulators.java.parser.parsedObjects.members;

import base.parsing.StringConstructed;
import base.parsing.StringDerived;
import regulators.java.parser.extractors.attributes.ParameterIdentifierExtractor;
import regulators.java.parser.extractors.attributes.ParameterTypeExtractor;
import regulators.java.parser.parsedObjects.attributes.TypeSelector;
import regulators.java.parser.providers.ParameterTypeProvider;

public class MethodParameter {
    @StringConstructed(extractor = ParameterIdentifierExtractor.class)
    private String identifier;

    @StringDerived(extractor = ParameterTypeExtractor.class, provider = ParameterTypeProvider.class)
    private TypeSelector type;
}
