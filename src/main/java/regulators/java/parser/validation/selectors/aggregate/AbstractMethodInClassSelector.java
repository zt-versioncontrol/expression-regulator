package regulators.java.parser.validation.selectors.aggregate;

import base.expressions.Expression;
import base.expressions.validation.selectors.simple.ByExtractor;
import base.expressions.validation.selectors.simple.ConcreteTypeSelector;
import regulators.java.parser.extractors.members.ClassMembersExtractor;
import regulators.java.parser.parsedObjects.members.AbstractMethod;

public class AbstractMethodInClassSelector extends ConcreteTypeSelector {
    protected AbstractMethodInClassSelector() {
        super(AbstractMethod.class);
    }

    @Override
    public boolean isSelected(Expression expression) {
        return super.isSelected(expression) && new ByExtractor(ClassMembersExtractor.class){}.isSelected(expression);
    }
}
