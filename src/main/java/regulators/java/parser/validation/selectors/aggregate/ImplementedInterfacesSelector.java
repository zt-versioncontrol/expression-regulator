package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.java.parser.extractors.associations.ClassImplementedInterfacesExtractor;
import regulators.java.parser.extractors.associations.EnumImplementedInterfacesExtractor;

import java.util.List;

public class ImplementedInterfacesSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractor(ClassImplementedInterfacesExtractor.class){},
            new ByExtractor(EnumImplementedInterfacesExtractor.class){}
    );

    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }
        return false;
    }
}
