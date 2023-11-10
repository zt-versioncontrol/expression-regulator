package regulators.java.parser.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.validation.selectors.simple.ConcreteTypeSelector;
import regulators.java.parser.parsedObjects.members.*;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.parsedObjects.types.ENum;
import regulators.java.parser.parsedObjects.types.INterface;
import regulators.java.parser.parsedObjects.types.InvalidTypeDefinition;

import java.util.Set;

public class ByConcreteTypeSelectors {

    public static class ClassSelector extends ConcreteTypeSelector {
        public ClassSelector() {
            super(CLass.class);
        }
    }

    public static class MethodSelector extends ConcreteTypeSelector {
        public MethodSelector() {
            super(MEthod.class);
        }
    }

    public static class EnumSelector extends ConcreteTypeSelector {
        public EnumSelector() {
            super(ENum.class);
        }
    }

    public static class InterfaceSelector extends ConcreteTypeSelector {
        public InterfaceSelector() {
            super(INterface.class);
        }
    }

    public static class AbstractMethodSelector extends ConcreteTypeSelector {
        public AbstractMethodSelector() {
            super(AbstractMethod.class);
        }
    }

    public static class InitializationBlockSelector extends ConcreteTypeSelector {
        public InitializationBlockSelector() {
            super(InitializationBlock.class);
        }
    }

    public static class InvalidTypeSelector extends ConcreteTypeSelector {
        public InvalidTypeSelector() {
            super(InvalidTypeDefinition.class);
        }
    }

    public static class EmptyMemberSelector extends ConcreteTypeSelector {
        public EmptyMemberSelector() {
            super(EmptyMember.class);
        }
    }

    public static class StaticBlockSelector extends ConcreteTypeSelector {
        public StaticBlockSelector() {
            super(StaticBlock.class);
        }
    }

    public static class _Initializer {
        public Set<BasicExpressionSelector> initialize(){
            return Set.of(
                    new ClassSelector(),
                    new MethodSelector(),
                    new EnumSelector(),
                    new InterfaceSelector(),
                    new AbstractMethodSelector(),
                    new InitializationBlockSelector(),
                    new InvalidTypeSelector(),
                    new EmptyMemberSelector(),
                    new StaticBlockSelector()
            );
        }
    }
}
