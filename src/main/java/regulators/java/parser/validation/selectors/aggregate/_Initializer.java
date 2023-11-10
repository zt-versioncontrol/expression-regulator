package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;

import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionSelector> initialize(){
        return Set.of(
                new AbstractMethodInClassSelector(),
                new FileTypeDefinitionQualifiersSelector(),
                new GenericsSelector(),
                new IdentifierSelector(),
                new ImplementedInterfacesSelector(),
                new NestedClassQualifiersSelector(),
                new NestedEnumQualifiersSelector(),
                new NestedInterfaceQualifiersSelector(),
                new QualifiersSelector(),
                new TypeMemberSelector(),
                new TypeSelectorSelector()
        );
    }
}
