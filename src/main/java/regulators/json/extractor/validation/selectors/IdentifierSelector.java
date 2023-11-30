package regulators.json.extractor.validation.selectors;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.json.extractor.extractors.*;

import java.util.List;

public class IdentifierSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractor(CompositionIdentifierExtractor.class) {},
            new ByExtractor(CompositionBaseExtractor.class) {},
            new ByExtractor(CompositionExtensionExtracttor.class) {},
            new ByExtractor(ExtractionIdentifierExtractor.class) {},
            new ByExtractor(SegmentIdentifierExtractor.class) {},
            new ByExtractor(SelectorIdentifierExtractor.class) {},
            new ByExtractor(PathStepsExtractor.class) {}
    );


    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }

        return false;
    }
}
