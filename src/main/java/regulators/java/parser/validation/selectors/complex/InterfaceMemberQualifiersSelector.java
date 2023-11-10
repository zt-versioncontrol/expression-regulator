package regulators.java.parser.validation.selectors.complex;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.java.parser.extractors.attributes.*;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectors;

import java.util.List;

public class InterfaceMemberQualifiersSelector implements BasicExpressionSelector {

    private final List<BasicExpressionSelector> subSelectors = List.of(
            new ByExtractor(ClassQualifiersExtractor.class){},
            new ByExtractor(EnumQualifiersExtractor.class){},
            new ByExtractor(InterfaceQualifiersExtractor.class){},
            new ByExtractor(MethodQualifiersExtractor.class){},
            new ByExtractor(FieldQualifiersExtractor.class){}
    );

    @Override
    public boolean isSelected(Expression expression) {
        ByConcreteTypeSelectors.InterfaceSelector interfaceSelector = new ByConcreteTypeSelectors.InterfaceSelector();

        for (BasicExpressionSelector subSelector : subSelectors) {
            if (subSelector.isSelected(expression)){
                //qualifier of class that is nested in interface or
                //qualifier of enum that is nested in interface or
                //qualifier of interface that is nested in interface or
                //qualifier of method that is nested in interface or
                //qualifier of abstract method that is nested in interface or
                //qualifier of field that is nested in interface
                if (interfaceSelector.isSelected(expression.getOriginalExpression().getOriginalExpression())){
                    return true;
                }
            }
        }

        return false;
    }
}
