package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractorAndExtractorOfOrigin;
import regulators.java.parser.extractors.attributes.InterfaceQualifiersExtractor;
import regulators.java.parser.extractors.members.ClassMembersExtractor;
import regulators.java.parser.extractors.members.EnumMembersExtractor;

import java.util.List;

public class NestedInterfaceQualifiersSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractorAndExtractorOfOrigin(InterfaceQualifiersExtractor.class, ClassMembersExtractor.class){},
            new ByExtractorAndExtractorOfOrigin(InterfaceQualifiersExtractor.class, EnumMembersExtractor.class){}
    );

    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }
        return false;
    }
}
