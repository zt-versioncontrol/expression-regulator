package regulators.java.parser.parsedObjects.members;

import base.parsing.StringConstructed;
import base.parsing.StringConstructedArray;
import base.parsing.StringDerived;
import regulators.java.parser.extractors.logic.FieldInitializerExtractor;
import regulators.java.parser.extractors.attributes.FieldIdentifierExtractor;
import regulators.java.parser.extractors.attributes.FieldQualifiersExtractor;
import regulators.java.parser.extractors.associations.FieldTypeExtractor;
import regulators.java.parser.parsedObjects.attributes.TypeSelector;
import regulators.java.parser.providers.FieldInitializerProvider;
import regulators.java.parser.providers.TypeSelectorProvider;

import java.util.ArrayList;

public class FIeld implements ClassMember, InterfaceMember, EnumMember {

    @StringConstructedArray(extractor = FieldQualifiersExtractor.class, of = String.class)
    private ArrayList<String> qualifiers;

    @StringDerived(extractor = FieldTypeExtractor.class, provider = TypeSelectorProvider.class)
    private TypeSelector type;

    @StringConstructed(extractor = FieldIdentifierExtractor.class)
    private String identifier;

    @StringDerived(extractor = FieldInitializerExtractor.class, provider = FieldInitializerProvider.class)
    private String initializer;

}
