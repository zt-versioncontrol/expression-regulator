package regulators.java.parser.extractors.associations;

import base.components.expression.parsing.ExtractorType;

import java.util.Set;

public class _Initializer {
    public Set<ExtractorType> initialize(){
        return Set.of(
                new ClassImplementedInterfacesExtractor(),
                new EnumImplementedInterfacesExtractor(),
                new ExtendedInterfacesExtractor(),
                new ExtendedInterfaceTypesExtractor(),
                new FieldTypeExtractor(),
                new GenericTypesSelectorsExtractor(),
                new ImplementedInterfaceTypesExtractor(),
                new MethodExceptionsExtractor(),
                new MethodTypeExtractor(),
                new ParameterTypeExtractor(),
                new SelectedTypeIdentifierExtractor(),
                new SuperClassExtractor(),
                new SuperClassTypeExtractor(),
                new TypeBoundExtractor()
        );
    }
}
