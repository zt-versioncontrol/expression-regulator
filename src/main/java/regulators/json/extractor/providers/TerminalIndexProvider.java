package regulators.json.extractor.providers;

import base.components.expression.parsing.InstanceProvider;
import utility.structure.Pair;

public class TerminalIndexProvider implements InstanceProvider {
    @Override
    public Pair<Integer,Integer> provide(String expression) {
        if (!expression.contains(":")){
            try {
                int intValue = Integer.parseInt(expression);
                return new Pair<>(intValue, intValue);
            }catch (NumberFormatException exception){
                return null;
            }
        }

        int colon = expression.indexOf(":");
        String first = expression.substring(0, colon);
        String second = expression.substring(colon+1);

        int start;
        int end;

        if (first.isEmpty()) start = -1;
        else{
            try {
                start = Integer.parseInt(first);
            }catch (NumberFormatException exception){
                return null;
            }
        }

        if (second.isEmpty()) end = -1;
        else{
            try {
                end = Integer.parseInt(second);
            }catch (NumberFormatException exception){
                return null;
            }
        }

        return new Pair<>(start, end);
    }
}
