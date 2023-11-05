package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.java.parser.extractors.members.ClassMembersExtractor;
import regulators.java.parser.extractors.members.EnumMembersExtractor;

import java.util.List;

public class TypeMemberSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractor(ClassMembersExtractor.class){},
            new ByExtractor(EnumMembersExtractor.class){}
    );

    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }

        return false;
    }
}
