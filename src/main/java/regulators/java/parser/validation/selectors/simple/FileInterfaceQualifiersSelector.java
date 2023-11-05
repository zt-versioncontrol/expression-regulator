package regulators.java.parser.validation.selectors.simple;

import base.expressions.validation.selectors.simple.ByExtractorAndExtractorOfOrigin;
import regulators.java.parser.extractors.attributes.InterfaceQualifiersExtractor;
import regulators.java.parser.extractors.members.TypeDefinitionsFromFileExtractor;

public class FileInterfaceQualifiersSelector extends ByExtractorAndExtractorOfOrigin {
    protected FileInterfaceQualifiersSelector() {
        super(InterfaceQualifiersExtractor.class, TypeDefinitionsFromFileExtractor.class);
    }
}
