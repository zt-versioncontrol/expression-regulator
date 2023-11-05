package regulators.java.parser.validation.selectors.simple;

import base.expressions.validation.selectors.simple.ByExtractorAndExtractorOfOrigin;
import regulators.java.parser.extractors.attributes.ClassQualifiersExtractor;
import regulators.java.parser.extractors.members.TypeDefinitionsFromFileExtractor;

public class FileCLassQualifiersSelector extends ByExtractorAndExtractorOfOrigin {
    protected FileCLassQualifiersSelector() {
        super(ClassQualifiersExtractor.class, TypeDefinitionsFromFileExtractor.class);
    }
}
