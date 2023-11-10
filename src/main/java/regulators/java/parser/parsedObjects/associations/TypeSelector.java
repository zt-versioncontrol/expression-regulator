package regulators.java.parser.parsedObjects.associations;

import base.parsing.StringConstructed;
import base.parsing.StringConstructedArray;
import regulators.java.parser.extractors.associations.GenericTypesSelectorsExtractor;
import regulators.java.parser.extractors.associations.SelectedTypeIdentifierExtractor;

import java.util.ArrayList;

public class TypeSelector {

    public TypeSelector(){}

    public TypeSelector(String expression){}

    @StringConstructed(extractor = SelectedTypeIdentifierExtractor.class)
    private String type;

    @StringConstructedArray(extractor = GenericTypesSelectorsExtractor.class, of = TypeSelector.class)
    private ArrayList<TypeSelector> genericTypesSelectors;

    public String getType() {
        return type;
    }

    public ArrayList<TypeSelector> getGenericTypesSelectors() {
        return genericTypesSelectors;
    }
}
