package regulators.java.parser.parsedObjects.members;

import base.parsing.StringConstructedArray;
import regulators.java.parser.extractors.members.GenericTypesExtractor;

import java.util.ArrayList;

public class Generics {

    @StringConstructedArray(extractor = GenericTypesExtractor.class, of = GenericType.class)
    private ArrayList<GenericType> genericTypes;

    public ArrayList<GenericType> getGenericTypes() {
        return genericTypes;
    }
}
