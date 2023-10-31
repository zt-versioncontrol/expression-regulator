package regulators.java.parser.parsedObjects.associations;

import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.associations.ExtendedInterfaceTypesExtractor;
import regulators.java.parser.parsedObjects.attributes.TypeSelector;
import regulators.java.parser.providers.TypeSelectorProvider;

import java.util.ArrayList;

public class ExtendedInterfaces {

    @StringDerivedArray(extractor = ExtendedInterfaceTypesExtractor.class, provider = TypeSelectorProvider.class)
    private ArrayList<TypeSelector> interfaceSelectors;
}
