package regulators.java.parser.validation.validators.wordValidators.qualifiers;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.QualifiersSelector;

import java.util.*;

public class UniqueQualifiersValifator extends BasicExpressionValidator {
    //the original expression of a qualifier is used as a key
    private final Map<Expression, Set<String>> uniqueQualifiersMap = new HashMap<>();

    private final List<String> mutuallyExclusiveKeywords = List.of("public", "private", "protected");

    protected UniqueQualifiersValifator() {
        super(QualifiersSelector.class);
    }


    @Override
    public boolean validate(Expression expression) {
        uniqueQualifiersMap.putIfAbsent(expression.getOriginalExpression(), new HashSet<>());

        Set<String> uniqueQualifiers = uniqueQualifiersMap.get(expression.getOriginalExpression());

        if (uniqueQualifiers.contains(expression.getExpressionString())) return false;
        uniqueQualifiers.add(expression.getExpressionString());

        int mutuallyExclusiveKeywordCount = 0;
        for (String mutuallyExclusiveKeyword : mutuallyExclusiveKeywords) {
            if (uniqueQualifiers.contains(mutuallyExclusiveKeyword)) mutuallyExclusiveKeywordCount++;
        }
        if (mutuallyExclusiveKeywordCount > 1) return false;

        return true;
    }
}
