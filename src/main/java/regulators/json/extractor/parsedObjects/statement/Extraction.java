package regulators.json.extractor.parsedObjects.statement;

import base.parsing.AbstractType;
import base.parsing.StringConstructed;
import base.parsing.StringDerived;
import regulators.json.extractor.extractors.ExtractionIdentifierExtractor;
import regulators.json.extractor.extractors.StructureExtractor;
import regulators.json.extractor.parsedObjects.structure.Structure;
import regulators.json.extractor.providers.structureProvider;

public class Extraction extends Statement {

    @StringConstructed(extractor = ExtractionIdentifierExtractor.class)
    private String identifier;

    @AbstractType
    @StringDerived(extractor = StructureExtractor.class, provider = structureProvider.class)
    private Structure structure;
}
