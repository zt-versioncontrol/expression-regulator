package base.routines.utility;

import java.util.Map;

public class ExpressionSwitcher<MATCHED extends Enum> {
    private final Map<ExpressionMatcher, MATCHED> matcherEMap;
    private final Map<MATCHED, SwitchAction> actionMap;


    public ExpressionSwitcher(Map<ExpressionMatcher, MATCHED> matcherEMap, Map<MATCHED, SwitchAction> actionMap) {
        this.matcherEMap = matcherEMap;
        this.actionMap = actionMap;
    }

    public void doSwitch(String expression){
        matcherEMap.forEach((expressionMatcher, matched) -> {
            if (expressionMatcher.check(expression) && actionMap.get(matched) != null)
                actionMap.get(matched).execute(expression);
        });
    }
}
