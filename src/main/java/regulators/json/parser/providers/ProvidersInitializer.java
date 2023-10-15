package regulators.json.parser.providers;

import base.components.expression.parsing.InstanceProvider;

import java.util.Set;

public class ProvidersInitializer {
    public Set<InstanceProvider> provide(){
        return Set.of(
                new BinaryValueProvider(),
                new NumberValueProvider(),
                new JsonProvider(),
                new PropertyProvider()
        );
    }
}
