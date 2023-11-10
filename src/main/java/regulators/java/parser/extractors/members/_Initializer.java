package regulators.java.parser.extractors.members;

import base.components.expression.parsing.ExtractorType;

import java.util.Set;

public class _Initializer {
    public Set<ExtractorType> initialize(){
        return Set.of(
                new ClassGenericsExtractor(),
                new ClassMembersExtractor(),
                new EnumConstantsExtractor(),
                new EnumMembersExtractor(),
                new GenericTypesExtractor(),
                new ImportsExtractor(),
                new InterfaceGenericsExtractor(),
                new MethodGenericsExtractor(),
                new MethodParametersExtractor(),
                new PackageExtractor(),
                new TypeDefinitionsFromFileExtractor()
        );
    }
}
