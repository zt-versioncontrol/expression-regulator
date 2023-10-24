package regulators.java.parser.parsedObjects.attributes;

import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.ImplementedInterfaceTypesExtractor;
import regulators.java.parser.providers.TypeSelectorProvider;

import java.util.ArrayList;

public class ImplementedInterfaces {
    @StringDerivedArray(extractor = ImplementedInterfaceTypesExtractor.class, provider = TypeSelectorProvider.class)
    private ArrayList<TypeSelector> interfaceSelectors;
}
