package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.extractor.parsedObjects.Iterator;

public class IteratorProvider implements InstanceProvider {
    @Override
    public Iterator provide(String expression) {
        if (expression.isEmpty()) return null;

        return new Iterator();
    }
}
