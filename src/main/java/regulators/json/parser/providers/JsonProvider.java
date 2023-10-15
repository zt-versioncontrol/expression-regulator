package regulators.json.parser.providers;

import base.components.expression.parsing.InstanceProvider;
import regulators.json.parser.parsedObjects.*;

public class JsonProvider implements InstanceProvider {
    @Override
    public Json provide(String expression) {
        if (expression.startsWith("{") && expression.endsWith("}")) return new JsonObject();
        else if (expression.startsWith("[") && expression.endsWith("]")) return new JsonArray();
        else if (expression.length() >=2 && expression.startsWith("\"") && expression.endsWith("\"")) return new JsonString();
        else if (expression.equals("true") || expression.equals("false")) return new JsonBinary();
        else if (isNumber(expression)) return new JsonNumber();
        else if (expression.equals("null")) return new JsonNull();
        return new JsonInvalid();
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
