package regulators.json.parser.providers;

import base.parsing.InstanceProvider;
import regulators.json.parser.parsedObjects.*;

public class JsonProvider implements InstanceProvider {
    @Override
    public Object provide(String expression) {
        if (expression.startsWith("{") && expression.endsWith("}")) return new JsonObject();
        else if (expression.startsWith("[") && expression.endsWith("]")) return new JsonArray();
        else if (expression.startsWith("\"") && expression.endsWith("\"")) return new JsonString();
        else if (expression.startsWith("'") && expression.endsWith("'")) return new JsonString();
        else if (expression.equalsIgnoreCase("true") || expression.equalsIgnoreCase("false")) return new JsonBinary();
        else if (isNumber(expression)) return new JsonNumber();
        else if (expression.equalsIgnoreCase("null")) return new JsonNull();
        return null;
    }


    private boolean isNumber(String s){
        try {
            Double.parseDouble(s);
        }catch (NumberFormatException exception){
            return false;
        }

        return true;
    }
}
