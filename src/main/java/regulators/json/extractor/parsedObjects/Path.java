package regulators.json.extractor.parsedObjects;

import base.parsing.StringConstructedArray;
import regulators.json.extractor.extractors.PathStepsExtractor;

import java.util.ArrayList;

public class Path {

    @StringConstructedArray(extractor = PathStepsExtractor.class, of = String.class)
    private ArrayList<String> steps;
}
