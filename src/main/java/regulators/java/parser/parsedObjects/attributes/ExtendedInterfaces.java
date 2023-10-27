package regulators.java.parser.parsedObjects.attributes;

import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.ExtendedInterfaceTypesExtractor;
import regulators.java.parser.providers.TypeSelectorProvider;

import java.util.ArrayList;

public class ExtendedInterfaces {

    @StringDerivedArray(extractor = ExtendedInterfaceTypesExtractor.class, provider = TypeSelectorProvider.class)
    private ArrayList<TypeSelector> interfaceSelectors;
}
