package regulators.java.parser.parsedObjects.types;

import base.parsing.StringConstructed;
import base.parsing.StringConstructedArray;
import base.parsing.StringDerived;
import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.attributes.EnumIdentifierExtractor;
import regulators.java.parser.extractors.associations.EnumImplementedInterfacesExtractor;
import regulators.java.parser.extractors.attributes.EnumQualifiersExtractor;
import regulators.java.parser.extractors.members.EnumConstantsExtractor;
import regulators.java.parser.extractors.members.EnumMembersExtractor;
import regulators.java.parser.parsedObjects.associations.ImplementedInterfaces;
import regulators.java.parser.parsedObjects.members.ClassMember;
import regulators.java.parser.parsedObjects.members.EnumMember;
import regulators.java.parser.parsedObjects.members.InterfaceMember;
import regulators.java.parser.providers.EnumMemberProvider;
import regulators.java.parser.providers.ImplementedInterfacesProvider;

import java.util.ArrayList;

public class ENum implements TypeDefinition, ClassMember, InterfaceMember, EnumMember {

    @StringConstructed(extractor = EnumIdentifierExtractor.class)
    private String identifier;

    @StringConstructedArray(extractor = EnumQualifiersExtractor.class, of = String.class)
    private ArrayList<String> qualifiers;

    @StringDerived(extractor = EnumImplementedInterfacesExtractor.class, provider = ImplementedInterfacesProvider.class)
    private ImplementedInterfaces implementedInterfaces;

    @StringConstructedArray(extractor = EnumConstantsExtractor.class, of = String.class)
    private ArrayList<String> constantIdentifiers;

    @StringDerivedArray(extractor = EnumMembersExtractor.class, provider = EnumMemberProvider.class)
    private ArrayList<EnumMember> members;

    public String getIdentifier() {
        return identifier;
    }

    public ArrayList<String> getQualifiers() {
        return qualifiers;
    }

    public ImplementedInterfaces getImplementedInterfaces() {
        return implementedInterfaces;
    }

    public ArrayList<String> getConstantIdentifiers() {
        return constantIdentifiers;
    }

    public ArrayList<EnumMember> getMembers() {
        return members;
    }
}
