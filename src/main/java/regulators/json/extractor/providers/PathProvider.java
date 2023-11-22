package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.extractor.parsedObjects.Path;

public class PathProvider implements InstanceProvider {
    @Override
    public Path provide(String expression) {
        if (expression.isEmpty()) return null;
        return new Path();
    }
}
