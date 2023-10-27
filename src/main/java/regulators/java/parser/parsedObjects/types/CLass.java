package regulators.java.parser.parsedObjects.types;

import base.parsing.*;
import regulators.java.parser.extractors.attributes.*;
import regulators.java.parser.extractors.members.ClassMembersExtractor;
import regulators.java.parser.parsedObjects.attributes.Generics;
import regulators.java.parser.parsedObjects.attributes.ImplementedInterfaces;
import regulators.java.parser.parsedObjects.attributes.SuperClass;
import regulators.java.parser.parsedObjects.members.ClassMember;
import regulators.java.parser.parsedObjects.members.EnumMember;
import regulators.java.parser.parsedObjects.members.InterfaceMember;
import regulators.java.parser.providers.ClassMemberProvider;
import regulators.java.parser.providers.GenericsProvider;
import regulators.java.parser.providers.ImplementedInterfacesProvider;
import regulators.java.parser.providers.SuperClassProvider;

import java.util.ArrayList;

public class CLass implements TypeDefinition, ClassMember, InterfaceMember, EnumMember {
    @StringConstructed(extractor = ClassIdentifierExtractor.class)
    private String identifier;

    @StringConstructedArray(extractor = ClassQualifiersExtractor.class, of = String.class)
    private ArrayList<String> qualifiers;

    @StringDerived(extractor = ClassGenericsExtractor.class, provider = GenericsProvider.class)
    private Generics generics;

    @StringDerived(extractor = superClassExtractor.class, provider = SuperClassProvider.class)
    private SuperClass superCLass;

    @StringDerived(extractor = ImplementedInterfacesExtractor.class, provider = ImplementedInterfacesProvider.class)
    private ImplementedInterfaces implementedInterfaces;

    @AbstractType
    @StringDerivedArray(extractor = ClassMembersExtractor.class, provider = ClassMemberProvider.class)
    private ArrayList<ClassMember> members;
}
