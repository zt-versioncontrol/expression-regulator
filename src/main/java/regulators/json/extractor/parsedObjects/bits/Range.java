package regulators.json.extractor.parsedObjects.bits;

import base.parsing.StringDerived;
import regulators.json.extractor.extractors.RangeEndExtractor;
import regulators.json.extractor.extractors.RangeStartExtractor;
import regulators.json.extractor.providers.RangeBoundProvider;

public class Range {
    public Range(String expression) {}

    //(-1, -1) all elements
    //(-1, 5) from start to 5, excluding 5
    //(0, 5) from start to 5, excluding 5
    //(3, -1) from 3 to last including 3

    @StringDerived(extractor = RangeStartExtractor.class, provider = RangeBoundProvider.class)
    private Integer start;

    @StringDerived(extractor = RangeEndExtractor.class, provider = RangeBoundProvider.class)
    private Integer end;
}
