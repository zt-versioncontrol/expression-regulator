package regulators.java.parser.parsedObjects.attributes;

import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.GenericTypesExtractor;
import regulators.java.parser.providers.GenericTypeProvidor;

import java.util.ArrayList;

public class ClassGenerics {

    @StringDerivedArray(extractor = GenericTypesExtractor.class, provider = GenericTypeProvidor.class)
    private ArrayList<GenericType> genericTypes;
}
