package regulators.json.parser.parsedObjects;

import base.parsing.AbstractType;
import base.parsing.StringDerivedArray;
import regulators.json.parser.extractors.JsonArrayElementsExtractor;
import regulators.json.parser.providers.JsonProvider;

import java.util.ArrayList;

public class JsonArray extends Json{
    @AbstractType
    @StringDerivedArray(extractor = JsonArrayElementsExtractor.class, provider = JsonProvider.class)
    private ArrayList<Json> array;

    public ArrayList<Json> getArray() {
        return array;
    }
}
