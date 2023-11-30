package regulators.json.extractor.validation.selectors;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.extractor.extractors.RangeEndExtractor;
import regulators.json.extractor.extractors.RangeStartExtractor;

import java.util.List;

public class RangeBoundSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractor(RangeStartExtractor.class) {},
            new ByExtractor(RangeEndExtractor.class) {}
    );

    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }
        return false;
    }
}
