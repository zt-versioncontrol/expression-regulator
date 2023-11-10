package base.drivers.parsing;

import base.components.expression.validation.BasicExpressionSelector;
import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;

import java.util.List;
import java.util.Map;

public class ExecutionReport {
    public final Exception thrownException;

    public final String rootString;
    public  final Expression expressionTree;
    public final Map<Class<? extends BasicExpressionSelector>, List<Expression>> selectedExpressions;
    public final List<Invalidation> invalidations;



    protected ExecutionReport(Exception thrownException, String rootString) {
        this.thrownException = thrownException;
        this.rootString = rootString;

        invalidations = null;
        expressionTree = null;
        selectedExpressions = null;
    }

    public ExecutionReport(String rootString,
                           Expression expressionTree,
                           List<Invalidation> invalidations,
                           Map<Class<? extends BasicExpressionSelector>, List<Expression>> selectedExpressions) {

        thrownException = null;
        this.rootString = rootString;
        this.invalidations = invalidations;
        this.expressionTree = expressionTree;
        this.selectedExpressions = selectedExpressions;
    }


    public static class Invalidation{
        public final Expression invalidExpression;
        public final Class<? extends BasicExpressionValidator> validator;

        public Invalidation(Expression invalidExpression, Class<? extends BasicExpressionValidator> validatorClass) {
            this.invalidExpression = invalidExpression;
            this.validator = validatorClass;
        }
    }

}
