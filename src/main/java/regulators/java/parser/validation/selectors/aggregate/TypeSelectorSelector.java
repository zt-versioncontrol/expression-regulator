package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.java.parser.extractors.associations.*;

import java.util.List;

public class TypeSelectorSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractor(ExtendedInterfaceTypesExtractor.class){},
            new ByExtractor(ImplementedInterfaceTypesExtractor.class){},
            new ByExtractor(SuperClassTypeExtractor.class){},
            new ByExtractor(GenericTypesSelectorsExtractor.class){},
            new ByExtractor(MethodTypeExtractor.class){},
            new ByExtractor(FieldTypeExtractor.class){},
            new ByExtractor(TypeBoundExtractor.class){},
            new ByExtractor(ParameterTypeExtractor.class){}
    );

    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }
        return false;
    }
}
