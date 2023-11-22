package regulators.json.extractor.parsedObjects;

import base.parsing.StringConstructedArray;
import regulators.json.extractor.extractors.RangesExtractor;

import java.util.ArrayList;

public class Iterator {

    @StringConstructedArray(extractor = RangesExtractor.class, of = Range.class)
    private ArrayList<Range> ranges;
}
