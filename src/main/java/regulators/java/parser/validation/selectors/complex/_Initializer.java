package regulators.java.parser.validation.selectors.complex;

import base.components.expression.validation.BasicExpressionSelector;

import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionSelector> initialize(){
        return Set.of(
                new InterfaceMemberQualifiersSelector()
        );
    }
}
