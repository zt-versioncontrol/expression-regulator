package regulators.java.parser.parsedObjects.associations;

import base.parsing.StringConstructed;
import regulators.java.parser.extractors.associations.SuperClassTypeExtractor;

public class SuperClass {
    @StringConstructed(extractor = SuperClassTypeExtractor.class)
    private TypeSelector selector;
}
