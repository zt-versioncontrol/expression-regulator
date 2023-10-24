package regulators.java.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.java.parser.parsedObjects.types.*;

import java.util.List;

public class TypeDefinitionProvider implements InstanceProvider {
    @Override
    public TypeDefinition provide(String expression) {
        int scopeStart = expression.indexOf('{');
        if (scopeStart != -1){
            String beforeScope = expression.substring(0, scopeStart);
            List<String> splits = List.of(beforeScope.split("\\s"));
            if (splits.contains("class")) return new CLass();
            if (splits.contains("interface")) return new INterface();
            if (splits.contains("enum")) return new ENum();
        }


        return new InvalidTypeDefinition();
    }
}
