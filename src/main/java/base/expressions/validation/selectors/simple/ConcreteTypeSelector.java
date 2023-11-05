package base.expressions.validation.selectors.simple;

import base.parsing._ConcreteTypeExtractor;

public class ConcreteTypeSelector extends HasDerivedByExtractor.WithMatcher{

    protected ConcreteTypeSelector(Class<?> concreteType) {
        super(_ConcreteTypeExtractor.class, string -> string.equals(concreteType.getTypeName()));
    }
}
