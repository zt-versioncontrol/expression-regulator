package regulators.java.parser.parsedObjects.members;

import base.parsing.StringConstructed;
import base.parsing.StringConstructedArray;
import base.parsing.StringDerived;
import regulators.java.parser.extractors.logic.FieldInitializerExtractor;
import regulators.java.parser.extractors.attributes.FieldIdentifierExtractor;
import regulators.java.parser.extractors.attributes.FieldQualifiersExtractor;
import regulators.java.parser.extractors.associations.FieldTypeExtractor;
import regulators.java.parser.parsedObjects.associations.TypeSelector;
import regulators.java.parser.providers.FieldInitializerProvider;

import java.util.ArrayList;

public class FIeld implements ClassMember, InterfaceMember, EnumMember {

    @StringConstructedArray(extractor = FieldQualifiersExtractor.class, of = String.class)
    private ArrayList<String> qualifiers;

    @StringConstructed(extractor = FieldTypeExtractor.class)
    private TypeSelector type;

    @StringConstructed(extractor = FieldIdentifierExtractor.class)
    private String identifier;

    @StringDerived(extractor = FieldInitializerExtractor.class, provider = FieldInitializerProvider.class)
    private String initializer;

    public ArrayList<String> getQualifiers() {
        return qualifiers;
    }

    public TypeSelector getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getInitializer() {
        return initializer;
    }
}
