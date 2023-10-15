package regulators.json.parser.parsedObjects;

import base.parsing.StringDerivedArray;
import regulators.json.parser.extractors.PropertiesExtractor;
import regulators.json.parser.providers.PropertyProvider;

import java.util.ArrayList;

public class JsonObject extends Json{
    @StringDerivedArray(extractor = PropertiesExtractor.class, provider = PropertyProvider.class)
    private ArrayList<Property> properties;

    public ArrayList<Property> getProperties() {
        return properties;
    }
}
