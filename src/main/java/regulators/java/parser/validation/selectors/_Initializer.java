package regulators.java.parser.validation.selectors;

import base.components.expression.validation.BasicExpressionSelector;

import java.util.HashSet;
import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionSelector> initialize(){
        Set<BasicExpressionSelector> selectors = new HashSet<>();

        selectors.addAll(new regulators.java.parser.validation.selectors.aggregate._Initializer().initialize());
        selectors.addAll(new regulators.java.parser.validation.selectors.complex._Initializer().initialize());
        selectors.addAll(new regulators.java.parser.validation.selectors.simple._Initializer().initialize());

        return selectors;
    }
}
