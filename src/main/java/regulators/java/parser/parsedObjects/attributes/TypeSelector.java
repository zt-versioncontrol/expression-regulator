package regulators.java.parser.parsedObjects.attributes;

import base.parsing.StringConstructed;
import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.GenericTypesSelectorsExtractor;
import regulators.java.parser.extractors.SelectorIdentifierExtractor;
import regulators.java.parser.providers.GenericTypeSelectorProvider;

import java.util.ArrayList;

public class TypeSelector {
    @StringConstructed(extractor = SelectorIdentifierExtractor.class)
    private String identifier;

    @StringDerivedArray(extractor = GenericTypesSelectorsExtractor.class, provider = GenericTypeSelectorProvider.class)
    private ArrayList<TypeSelector> genericTypesSelectors;
}
