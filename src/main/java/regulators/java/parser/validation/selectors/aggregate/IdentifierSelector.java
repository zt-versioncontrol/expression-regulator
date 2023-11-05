package regulators.java.parser.validation.selectors.aggregate;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.java.parser.extractors.associations.MethodExceptionsExtractor;
import regulators.java.parser.extractors.associations.SelectedTypeIdentifierExtractor;
import regulators.java.parser.extractors.attributes.*;
import regulators.java.parser.extractors.members.EnumConstantsExtractor;

import java.util.List;

public class IdentifierSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors;

    public IdentifierSelector() {
        subSelectors = List.of(
                (new ByExtractor(ClassIdentifierExtractor.class){}),
                (new ByExtractor(EnumIdentifierExtractor.class){}),
                (new ByExtractor(EnumConstantsExtractor.class){}),
                (new ByExtractor(InterfaceIdentifierExtractor.class){}),
                (new ByExtractor(MethodIdentifierExtractor.class){}),
                (new ByExtractor(MethodExceptionsExtractor.class){}),
                (new ByExtractor(FieldIdentifierExtractor.class) {}),
                (new ByExtractor(GenericTypeIdentifierExtractor.class) {}),
                (new ByExtractor(ParameterIdentifierExtractor.class){}),
                (new ByExtractor(SelectedTypeIdentifierExtractor.class) {})
        );
    }

    @Override
    public boolean isSelected(Expression expression) {
        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)) return true;
        }

        return false;
    }
}
