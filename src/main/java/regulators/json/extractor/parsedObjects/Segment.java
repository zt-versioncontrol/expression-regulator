package regulators.json.extractor.parsedObjects;


import base.parsing.StringConstructed;
import base.parsing.StringDerived;
import regulators.json.extractor.extractors.IteratorExtractor;
import regulators.json.extractor.extractors.PathExtractor;
import regulators.json.extractor.extractors.SegmentIdentifierExtractor;
import regulators.json.extractor.providers.IteratorProvider;
import regulators.json.extractor.providers.PathProvider;

public class Segment extends Statement {

    @StringConstructed(extractor = SegmentIdentifierExtractor.class)
    private String identifier;

    @StringDerived(extractor = IteratorExtractor.class, provider = IteratorProvider.class)
    private Iterator iterator;

    @StringDerived(extractor = PathExtractor.class, provider = PathProvider.class)
    private Path path;
}
