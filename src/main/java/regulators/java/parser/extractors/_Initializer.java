package regulators.java.parser.extractors;

import base.components.expression.parsing.ExtractorType;

import java.util.HashSet;
import java.util.Set;

public class _Initializer {
    public Set<ExtractorType> initialize(){
        Set<ExtractorType> extractors = new HashSet<>();

        extractors.addAll(new regulators.java.parser.extractors.associations._Initializer().initialize());
        extractors.addAll(new regulators.java.parser.extractors.attributes._Initializer().initialize());
        extractors.addAll(new regulators.java.parser.extractors.logic._Initializer().initialize());
        extractors.addAll(new regulators.java.parser.extractors.members._Initializer().initialize());

        return extractors;
    }
}
