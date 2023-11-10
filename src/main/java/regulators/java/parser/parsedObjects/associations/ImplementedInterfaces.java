package regulators.java.parser.parsedObjects.associations;

import base.parsing.StringConstructedArray;
import regulators.java.parser.extractors.associations.ImplementedInterfaceTypesExtractor;

import java.util.ArrayList;

public class ImplementedInterfaces {
    @StringConstructedArray(extractor = ImplementedInterfaceTypesExtractor.class, of = TypeSelector.class)
    private ArrayList<TypeSelector> interfaceSelectors;

    public ArrayList<TypeSelector> getInterfaceSelectors() {
        return interfaceSelectors;
    }
}
