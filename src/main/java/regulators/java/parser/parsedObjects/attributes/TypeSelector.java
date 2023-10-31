package regulators.java.parser.parsedObjects.attributes;

import base.parsing.StringConstructed;
import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.associations.GenericTypesSelectorsExtractor;
import regulators.java.parser.extractors.associations.SelectedTypeIdentifierExtractor;
import regulators.java.parser.providers.GenericTypeSelectorProvider;

import java.util.ArrayList;

public class TypeSelector {
    @StringConstructed(extractor = SelectedTypeIdentifierExtractor.class)
    private String type;

    @StringDerivedArray(extractor = GenericTypesSelectorsExtractor.class, provider = GenericTypeSelectorProvider.class)
    private ArrayList<TypeSelector> genericTypesSelectors;
}
