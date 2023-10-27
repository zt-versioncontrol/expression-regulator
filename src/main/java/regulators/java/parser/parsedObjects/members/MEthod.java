package regulators.java.parser.parsedObjects.members;

import base.parsing.StringConstructed;
import base.parsing.StringConstructedArray;
import base.parsing.StringDerived;
import base.parsing.StringDerivedArray;
import regulators.java.parser.extractors.attributes.MethodExceptionsExtractor;
import regulators.java.parser.extractors.attributes.MethodIdentifierExtractor;
import regulators.java.parser.extractors.attributes.MethodQualifiersExtractor;
import regulators.java.parser.extractors.attributes.MethodTypeExtractor;
import regulators.java.parser.extractors.logic.StatementsExtractor;
import regulators.java.parser.extractors.members.MethodParametersExtractor;
import regulators.java.parser.parsedObjects.attributes.TypeSelector;
import regulators.java.parser.parsedObjects.logic.Statement;
import regulators.java.parser.providers.MethodParameterProvider;
import regulators.java.parser.providers.StatementProvider;
import regulators.java.parser.providers.TypeSelectorProvider;

import java.util.ArrayList;

public class MEthod implements ClassMember, InterfaceMember, EnumMember {

    @StringConstructedArray(extractor = MethodQualifiersExtractor.class, of = String.class)
    private ArrayList<String> qualifiers;

    @StringDerived(extractor = MethodTypeExtractor.class, provider = TypeSelectorProvider.class)
    private TypeSelector type;

    @StringConstructed(extractor = MethodIdentifierExtractor.class)
    private String identifier;

    @StringDerivedArray(extractor = MethodParametersExtractor.class, provider = MethodParameterProvider.class)
    private ArrayList<MethodParameter> parameters;

    @StringConstructedArray(extractor = MethodExceptionsExtractor.class, of = String.class)
    private ArrayList<String> thrownExpections;

    @StringDerivedArray(extractor = StatementsExtractor.class, provider = StatementProvider.class)
    private ArrayList<Statement> statements;
}
