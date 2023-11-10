package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;

import java.util.Set;

public class _Initializer {
    public Set<InstanceProvider> initialize(){
        return Set.of(
                new ClassMemberProvider(),
                new EnumMemberProvider(),
                new ExtendedInterfacesProvider(),
                new FieldInitializerProvider(),
                new GenericsProvider(),
                new ImplementedInterfacesProvider(),
                new InterfaceMemberProvider(),
                new SuperClassProvider(),
                new TypeBoundProvider(),
                new TypeDefinitionProvider()
        );
    }
}
