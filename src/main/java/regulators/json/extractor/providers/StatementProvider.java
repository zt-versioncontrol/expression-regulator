package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.extractor.parsedObjects.Composition;
import regulators.json.extractor.parsedObjects.Extraction;
import regulators.json.extractor.parsedObjects.Segment;
import regulators.json.extractor.parsedObjects.Statement;

public class StatementProvider implements InstanceProvider {
    @Override
    public Statement provide(String expression) {
        if (expression.contains("=")) return new Segment();
        else if (expression.contains("<")) return new Composition();
        else return new Extraction();
    }
}
