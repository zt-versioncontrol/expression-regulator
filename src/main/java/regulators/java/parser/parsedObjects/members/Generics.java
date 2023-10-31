package regulators.java.parser.parsedObjects.members;

import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.members.GenericTypesExtractor;
import regulators.java.parser.parsedObjects.attributes.GenericType;
import regulators.java.parser.providers.GenericTypeProvidor;

import java.util.ArrayList;

public class Generics {

    @StringDerivedArray(extractor = GenericTypesExtractor.class, provider = GenericTypeProvidor.class)
    private ArrayList<GenericType> genericTypes;
}
