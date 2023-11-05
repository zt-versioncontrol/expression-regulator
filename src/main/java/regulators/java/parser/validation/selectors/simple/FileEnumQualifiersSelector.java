package regulators.java.parser.validation.selectors.simple;

import base.expressions.validation.selectors.simple.ByExtractorAndExtractorOfOrigin;
import regulators.java.parser.extractors.attributes.EnumQualifiersExtractor;
import regulators.java.parser.extractors.members.TypeDefinitionsFromFileExtractor;

public class FileEnumQualifiersSelector extends ByExtractorAndExtractorOfOrigin {
    protected FileEnumQualifiersSelector() {
        super(EnumQualifiersExtractor.class, TypeDefinitionsFromFileExtractor.class);
    }
}
