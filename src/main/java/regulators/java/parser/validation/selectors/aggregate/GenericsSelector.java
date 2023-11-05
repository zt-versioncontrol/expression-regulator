package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.java.parser.extractors.members.ClassGenericsExtractor;
import regulators.java.parser.extractors.members.InterfaceGenericsExtractor;
import regulators.java.parser.extractors.members.MethodGenericsExtractor;

import java.util.List;

public class GenericsSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractor(ClassGenericsExtractor.class){},
            new ByExtractor(InterfaceGenericsExtractor.class){},
            new ByExtractor(MethodGenericsExtractor.class){}
    );

    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }
        return false;
    }
}
