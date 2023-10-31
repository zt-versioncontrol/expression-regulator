package regulators.java.parser.parsedObjects.attributes;

import base.parsing.StringDerived;
import regulators.java.parser.extractors.associations.SuperClassTypeExtractor;
import regulators.java.parser.providers.TypeSelectorProvider;

public class SuperClass {
    @StringDerived(extractor = SuperClassTypeExtractor.class, provider = TypeSelectorProvider.class)
    private TypeSelector selector;
}
