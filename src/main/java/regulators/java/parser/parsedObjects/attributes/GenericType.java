package regulators.java.parser.parsedObjects.attributes;

import base.parsing.StringConstructed;
import base.parsing.StringDerived;
import regulators.java.parser.extractors.GenericTypeIdentifierExtractor;
import regulators.java.parser.extractors.attributes.TypeBoundExtractor;
import regulators.java.parser.providers.TypeBoundProvider;

public class GenericType {
    @StringConstructed(extractor = GenericTypeIdentifierExtractor.class)
    private String identifier;

    @StringDerived(extractor = TypeBoundExtractor.class, provider = TypeBoundProvider.class)
    private TypeSelector typeBound;

}
