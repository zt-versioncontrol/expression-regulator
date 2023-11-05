package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.java.parser.extractors.attributes.*;

import java.util.List;

public class QualifiersSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractor(ClassQualifiersExtractor.class) {},
            new ByExtractor(EnumQualifiersExtractor.class) {},
            new ByExtractor(InterfaceQualifiersExtractor.class) {},
            new ByExtractor(MethodQualifiersExtractor.class) {},
            new ByExtractor(FieldQualifiersExtractor.class) {}
    );


    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }
        return false;
    }
}
