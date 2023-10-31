package regulators.java.parser.parsedObjects;

import base.parsing.AbstractType;
import base.parsing.StringConstructed;
import base.parsing.StringConstructedArray;
import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.members.ImportsExtractor;
import regulators.java.parser.extractors.members.PackageExtractor;
import regulators.java.parser.extractors.members.TypeDefinitionsFromFileExtractor;
import regulators.java.parser.parsedObjects.types.TypeDefinition;
import regulators.java.parser.providers.TypeDefinitionProvider;

import java.util.ArrayList;

public class File {
    @StringConstructed(extractor = PackageExtractor.class)
    private String pkg;

    @StringConstructedArray(extractor = ImportsExtractor.class, of = String.class)
    private ArrayList<String> imports;

    @AbstractType
    @StringDerivedArray(extractor = TypeDefinitionsFromFileExtractor.class, provider = TypeDefinitionProvider.class)
    private ArrayList<TypeDefinition> classes;

}
