package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.extractor.parsedObjects.trash.ArrayTerminal;
import regulators.json.extractor.parsedObjects.trash.ObjectTerminal;
import regulators.json.extractor.parsedObjects.trash.Terminal;

public class TerminalProvider implements InstanceProvider {
    @Override
    public Terminal provide(String expression) {
        if (expression.startsWith("[")) return new ArrayTerminal();
        else return new ObjectTerminal();
    }
}
