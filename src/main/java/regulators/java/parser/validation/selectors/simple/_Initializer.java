package regulators.java.parser.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;

import java.util.HashSet;
import java.util.Set;

public class _Initializer {
    public Set<BasicExpressionSelector> initialize(){
        Set<BasicExpressionSelector> selectors = new HashSet<>();

        selectors.addAll(new ByConcreteTypeSelectors._Initializer().initialize());
        selectors.addAll(new ByExtractorSelectors._Initializer().initialize());
        selectors.add(new FileCLassQualifiersSelector());
        selectors.add(new FileEnumQualifiersSelector());
        selectors.add(new FileInterfaceQualifiersSelector());

        return selectors;
    }
}
