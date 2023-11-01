package regulators.java.parser.parsedObjects.members;

import base.parsing.StringConstructed;
import base.parsing.StringConstructedArray;
import base.parsing.StringDerived;
import regulators.java.parser.extractors.associations.MethodExceptionsExtractor;
import regulators.java.parser.extractors.attributes.MethodIdentifierExtractor;
import regulators.java.parser.extractors.attributes.MethodQualifiersExtractor;
import regulators.java.parser.extractors.associations.MethodTypeExtractor;
import regulators.java.parser.extractors.members.MethodGenericsExtractor;
import regulators.java.parser.extractors.members.MethodParametersExtractor;
import regulators.java.parser.parsedObjects.associations.TypeSelector;
import regulators.java.parser.providers.GenericsProvider;

import java.util.ArrayList;

public class AbstractMethod implements ClassMember, InterfaceMember {

    @StringConstructedArray(extractor = MethodQualifiersExtractor.class, of = String.class)
    private ArrayList<String> qualifiers;

    @StringDerived(extractor = MethodGenericsExtractor.class, provider = GenericsProvider.class)
    private Generics generics;

    @StringConstructed(extractor = MethodTypeExtractor.class)
    private TypeSelector type;

    @StringConstructed(extractor = MethodIdentifierExtractor.class)
    private String identifier;

    @StringConstructedArray(extractor = MethodParametersExtractor.class, of = MethodParameter.class)
    private ArrayList<MethodParameter> parameters;

    @StringConstructedArray(extractor = MethodExceptionsExtractor.class, of = String.class)
    private ArrayList<String> thrownExpections;
}
