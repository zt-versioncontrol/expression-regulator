package base.drivers.parsing;

import base.components.expression.*;
import base.components.expression.parsing.*;
import base.components.expression.validation.*;
import base.expressions.Expression;
import base.parsing.ExpressionToObjectParser;
import base.parsing.ParsingUtilitiesService;

import java.util.*;

// TODO: 10/12/2023 see if unit test is required
public class ParsingDriver<T> {
    private final ReportingService reportingService;

    private final Set<BasicExpressionSelector> selectors = new HashSet<>();
    private final Set<BasicExpressionValidator> validators = new HashSet<>();
    private final Map<Class<? extends BasicExpressionSelector>, List<Expression>> selectedExpressions = new HashMap<>();

    private final ExpressionToObjectParser parser;

    protected ParsingDriver(ExpressionComponentsInitializer componentsInitializer){
        this(componentsInitializer, null);
    }

    protected ParsingDriver(ExpressionComponentsInitializer componentsInitializers, ReportingService reportingService){
        this.reportingService = reportingService;

        Set<ExpressionComponent> components = componentsInitializers.initialize();
        ParsingUtilitiesService parsingUtilitiesService = new ParsingUtilitiesService();

        for (ExpressionComponent component : components) {
            if (component instanceof ExpressionArrayExtractor extractor){
                parsingUtilitiesService.addExpressionArrayExtractor(extractor);
            }else if (component instanceof ExpressionExtractor extractor){
                parsingUtilitiesService.addExpressionExtractor(extractor);
            }else if (component instanceof InstanceProvider provider){
                parsingUtilitiesService.addInstanceProvider(provider);
            }else if(component instanceof BasicExpressionSelector selector){
                selectors.add(selector);
            }else if(component instanceof BasicExpressionValidator validator){
                validators.add(validator);
            }
        }

        parser = new ExpressionToObjectParser(parsingUtilitiesService);
    }


    protected T execute(T target, String expression){

        selectors.forEach(selector -> selectedExpressions.put(selector.getClass(), new ArrayList<>()));

        Expression expressionTree;
        try {
            expressionTree = parser.parse(target, expression);
        }catch (Exception exception){
            if (reportingService != null) reportingService.addExecutionReport(new ExecutionReport(exception, expression));
            return null;
        }


        executeSelectors(expressionTree);

        if (reportingService != null) {
            reportingService.addExecutionReport(new ExecutionReport(expression, expressionTree, executeValidators(), selectedExpressions));
        }
        return target;
    }

    private void executeSelectors(Expression expressionTree){
        for (BasicExpressionSelector selector : selectors) {
            if (selector.isSelected(expressionTree)){
                selectedExpressions.get(selector.getClass()).add(expressionTree);
            }
        }

        for (Expression derivedExpression : expressionTree.getDerivedExpressions()) {
            executeSelectors(derivedExpression);
        }
    }

    private List<ExecutionReport.Invalidation> executeValidators(){
        List<ExecutionReport.Invalidation> invalidations = new ArrayList<>();

        for (BasicExpressionValidator validator : validators) {
            for (Expression expression : selectedExpressions.get(validator.selectorClass)) {
                if (!validator.validate(expression)){
                    invalidations.add(new ExecutionReport.Invalidation(expression, validator.getClass()));
                }
            }
        }

        return invalidations;
    }
}
