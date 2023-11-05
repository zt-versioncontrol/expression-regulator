package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import base.parsing._ConcreteTypeExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteTypeSelectorTest {

    ConcreteTypeSelector selector = new ConcreteTypeSelector(String.class);

    @Test
    void isSelected() {
        Expression expression1 = new Expression("", null);
        Expression concreteTypeExpression1 = new Expression(String.class.getTypeName(), _ConcreteTypeExtractor.class);
        expression1.addDerivedExpression(concreteTypeExpression1);

        Expression expression2 = new Expression("", null);
        Expression concreteTypeExpression2 = new Expression(Integer.class.getTypeName(), _ConcreteTypeExtractor.class);
        expression2.addDerivedExpression(concreteTypeExpression2);

        Expression expression3 = new Expression("", null);

        assertTrue(selector.isSelected(expression1));
        assertFalse(selector.isSelected(expression2));
        assertFalse(selector.isSelected(expression3));
    }
}