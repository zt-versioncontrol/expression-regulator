package regulators.java.parser.parsedObjects.types;

import base.parsing.StringConstructed;
import base.parsing.StringConstructedArray;
import base.parsing.StringDerived;
import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.associations.ExtendedInterfacesExtractor;
import regulators.java.parser.extractors.members.InterfaceGenericsExtractor;
import regulators.java.parser.extractors.attributes.InterfaceIdentifierExtractor;
import regulators.java.parser.extractors.attributes.InterfaceQualifiersExtractor;
import regulators.java.parser.extractors.members.ClassMembersExtractor;
import regulators.java.parser.parsedObjects.associations.ExtendedInterfaces;
import regulators.java.parser.parsedObjects.members.Generics;
import regulators.java.parser.parsedObjects.members.*;
import regulators.java.parser.providers.ExtendedInterfacesProvider;
import regulators.java.parser.providers.InterfaceMemberProvider;
import regulators.java.parser.providers.GenericsProvider;

import java.util.ArrayList;

public class INterface implements TypeDefinition, ClassMember, InterfaceMember, EnumMember {

    @StringConstructed(extractor = InterfaceIdentifierExtractor.class)
    private String identifier;

    @StringConstructedArray(extractor = InterfaceQualifiersExtractor.class, of = String.class)
    private ArrayList<String> qualifiers;

    @StringDerived(extractor = InterfaceGenericsExtractor.class, provider = GenericsProvider.class)
    private Generics generics;

    @StringDerived(extractor = ExtendedInterfacesExtractor.class, provider = ExtendedInterfacesProvider.class)
    private ExtendedInterfaces extendedInterfaces;

    @StringDerivedArray(extractor = ClassMembersExtractor.class, provider = InterfaceMemberProvider.class)
    private ArrayList<InterfaceMember> members;
}
