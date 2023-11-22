package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.extractor.parsedObjects.Array;
import regulators.json.extractor.parsedObjects.NamedArrays;
import regulators.json.extractor.parsedObjects.Single;
import regulators.json.extractor.parsedObjects.Structure;

public class structureProvider implements InstanceProvider {
    @Override
    public Structure provide(String expression) {
        if (expression.startsWith("[")) return new Array();
        if (expression.startsWith("{")) return new NamedArrays();
        return new Single();
    }
}
