package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.extractor.parsedObjects.statement.Composition;
import regulators.json.extractor.parsedObjects.statement.Extraction;
import regulators.json.extractor.parsedObjects.statement.Segment;
import regulators.json.extractor.parsedObjects.statement.Statement;

public class StatementProvider implements InstanceProvider {
    @Override
    public Statement provide(String expression) {
        if (expression.contains("=")) return new Segment();
        else if (expression.contains("<")) return new Composition();
        else return new Extraction();
    }
}
