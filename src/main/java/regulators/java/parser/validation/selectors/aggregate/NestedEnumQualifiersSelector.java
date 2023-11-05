package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractorAndExtractorOfOrigin;
import regulators.java.parser.extractors.attributes.EnumQualifiersExtractor;
import regulators.java.parser.extractors.members.ClassMembersExtractor;
import regulators.java.parser.extractors.members.EnumMembersExtractor;

import java.util.List;

public class NestedEnumQualifiersSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractorAndExtractorOfOrigin(EnumQualifiersExtractor.class, ClassMembersExtractor.class) {},
            new ByExtractorAndExtractorOfOrigin(EnumQualifiersExtractor.class, EnumMembersExtractor.class) {}
    );


    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }
        return false;
    }
}
