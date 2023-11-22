package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;

public class RangeBoundProvider implements InstanceProvider {
    @Override
    public Integer provide(String expression) {
        if (expression.isBlank()) return -1;

        try {
            return Integer.parseInt(expression);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
