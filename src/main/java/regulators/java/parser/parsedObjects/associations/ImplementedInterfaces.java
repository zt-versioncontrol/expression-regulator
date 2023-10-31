package regulators.java.parser.parsedObjects.associations;

import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.associations.ImplementedInterfaceTypesExtractor;
import regulators.java.parser.parsedObjects.attributes.TypeSelector;
import regulators.java.parser.providers.TypeSelectorProvider;

import java.util.ArrayList;

public class ImplementedInterfaces {
    @StringDerivedArray(extractor = ImplementedInterfaceTypesExtractor.class, provider = TypeSelectorProvider.class)
    private ArrayList<TypeSelector> interfaceSelectors;
}
