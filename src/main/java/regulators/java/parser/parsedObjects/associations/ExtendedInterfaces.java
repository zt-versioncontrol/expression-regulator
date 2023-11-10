package regulators.java.parser.parsedObjects.associations;

import base.parsing.StringConstructedArray;
import regulators.java.parser.extractors.associations.ExtendedInterfaceTypesExtractor;

import java.util.ArrayList;

public class ExtendedInterfaces {

    @StringConstructedArray(extractor = ExtendedInterfaceTypesExtractor.class, of = TypeSelector.class)
    private ArrayList<TypeSelector> interfaceSelectors;

    public ArrayList<TypeSelector> getInterfaceSelectors() {
        return interfaceSelectors;
    }
}
