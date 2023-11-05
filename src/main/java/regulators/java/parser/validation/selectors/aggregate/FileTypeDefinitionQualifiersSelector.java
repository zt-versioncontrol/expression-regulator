package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractorAndExtractorOfOrigin;
import regulators.java.parser.extractors.attributes.ClassQualifiersExtractor;
import regulators.java.parser.extractors.attributes.EnumQualifiersExtractor;
import regulators.java.parser.extractors.attributes.InterfaceQualifiersExtractor;
import regulators.java.parser.extractors.members.TypeDefinitionsFromFileExtractor;

import java.util.List;

public class FileTypeDefinitionQualifiersSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractorAndExtractorOfOrigin(ClassQualifiersExtractor.class, TypeDefinitionsFromFileExtractor.class){},
            new ByExtractorAndExtractorOfOrigin(InterfaceQualifiersExtractor.class, TypeDefinitionsFromFileExtractor.class){},
            new ByExtractorAndExtractorOfOrigin(EnumQualifiersExtractor.class, TypeDefinitionsFromFileExtractor.class) {}
    );

    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }
        return false;
    }
}
