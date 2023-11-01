package regulators.java.parser.parsedObjects.members;

import base.parsing.StringConstructed;
import base.parsing.StringDerived;
import regulators.java.parser.extractors.attributes.GenericTypeIdentifierExtractor;
import regulators.java.parser.extractors.associations.TypeBoundExtractor;
import regulators.java.parser.parsedObjects.associations.TypeSelector;
import regulators.java.parser.providers.TypeBoundProvider;

public class GenericType {

    public GenericType(String expression) {

    }

    @StringConstructed(extractor = GenericTypeIdentifierExtractor.class)
    private String identifier;

    @StringDerived(extractor = TypeBoundExtractor.class, provider = TypeBoundProvider.class)
    private TypeSelector typeBound;

}
