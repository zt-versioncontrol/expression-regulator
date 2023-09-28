package utility.string;

import utility.structure.Pair;

import java.util.ArrayList;
import java.util.List;

public class SearchingUtilities {
    private SearchingUtilities() {}

    public static List<Integer> indicesOf(String expression, String target){
        List<Integer> indices = new ArrayList<>();
        int nextIndex = expression.indexOf(target);
        while (nextIndex != -1){
            indices.add(nextIndex);
            nextIndex = expression.indexOf(target, nextIndex + target.length());
        }

        return indices;
    }

    public static List<Integer> unscopedIndecisOf(String expression, List<Pair<Integer, Integer>> scopes, String target){
        List<Integer> indices = indicesOf(expression, target);
        List<Integer> unscopedIndices = new ArrayList<>();

        for (Integer index : indices) {
            boolean isUnscoped = true;
            for (Pair<Integer, Integer> scope : scopes) {
                if (scope.second == -1 && index >= scope.first) isUnscoped = false;
                else if (index >= scope.first && index <= scope.second) isUnscoped = false;
            }
            if (isUnscoped) unscopedIndices.add(index);
        }

        return unscopedIndices;
    }
}
