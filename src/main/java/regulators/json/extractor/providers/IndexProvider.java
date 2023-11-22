package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;

public class IndexProvider implements InstanceProvider {
    @Override
    public Integer provide(String expression) {
        try {
            return Integer.parseInt(expression);
        }catch (NumberFormatException exception){
            return null;
        }
    }
}
