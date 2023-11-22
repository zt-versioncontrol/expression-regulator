package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.extractor.parsedObjects.trash.ArrayStep;
import regulators.json.extractor.parsedObjects.trash.ObjectStep;
import regulators.json.extractor.parsedObjects.trash.Step;

public class StepProvider implements InstanceProvider {
    @Override
    public Step provide(String expression) {
        if (expression.startsWith("[")) return new ArrayStep();
        return new ObjectStep();
    }
}
