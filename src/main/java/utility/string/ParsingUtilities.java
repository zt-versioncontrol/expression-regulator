package utility.string;

import utility.structure.Pair;

import java.util.ArrayList;
import java.util.List;

public class ParsingUtilities {
    private ParsingUtilities() {}

    //returns (-1, -1) if no scope was found
    //returns (index, -1) if closing scope was not found
    //ignores scope closing indicators if they were not preceded by opening indicators
    public static Pair<Integer, Integer> firstDepthOneScopeBoundaries(String expression, String leftIndicator, String rightIndicator){
        int firstScopeStart = expression.indexOf(leftIndicator);
        if (firstScopeStart == -1) return new Pair<>(-1, -1);

        int nextLeftIndex = expression.indexOf(leftIndicator, firstScopeStart + leftIndicator.length());
        int nextRightIndex = expression.indexOf(rightIndicator);
        int depth = 1;
        while (nextRightIndex >= 0) {
            if (firstScopeStart > nextRightIndex){
                nextRightIndex = expression.indexOf(rightIndicator, nextRightIndex + rightIndicator.length());
            } else if (nextLeftIndex > nextRightIndex || nextLeftIndex == -1) {
                if (depth == 1) {
                    return new Pair<>(firstScopeStart, nextRightIndex + rightIndicator.length() - 1);
                }
                nextRightIndex = expression.indexOf(rightIndicator, nextRightIndex + rightIndicator.length());
                depth--;
            } else {
                depth++;
                nextLeftIndex = expression.indexOf(leftIndicator, nextLeftIndex + leftIndicator.length());
            }
        }

        return new Pair<>(firstScopeStart, -1);
    }

    public static List<Pair<Integer, Integer>> depthOneScopeBoundaries(String expression, String startIndicator, String endIndicator){
        List<Pair<Integer, Integer>> scopeBoundaries = new ArrayList<>();
        Pair<Integer, Integer> nextScopeBoundaries = firstDepthOneScopeBoundaries(expression, startIndicator, endIndicator);
        int offset = 0;
        while (nextScopeBoundaries.first != -1){
            scopeBoundaries.add(
                    new Pair<>(nextScopeBoundaries.first + offset,
                            nextScopeBoundaries.second == -1? -1 : nextScopeBoundaries.second + offset)
            );

            if (nextScopeBoundaries.second != -1) {
                expression = expression.substring(nextScopeBoundaries.second + 1);
                offset += nextScopeBoundaries.second + 1;
                nextScopeBoundaries = firstDepthOneScopeBoundaries(expression, startIndicator, endIndicator);
            }else {
                break;
            }
        }

        return scopeBoundaries;
    }



    public static List<Pair<Integer, Integer>> symmetricScopeBoundaries(String expression, String indicator){
        List<Integer> indicatorIndices = SearchingUtilities.indicesOf(expression, indicator);
        List<Pair<Integer, Integer>> boundaries = new ArrayList<>();

        for (int i = 0; i < indicatorIndices.size(); i+=2) {
            int start = indicatorIndices.get(i);
            int end = indicatorIndices.size() > (i+1)? indicatorIndices.get(i+1) + (indicator.length()-1) : -1;
            boundaries.add(new Pair<>(start, end));
        }

        return boundaries;
    }

    public static List<String> indexSplit(String string, List<Integer> indices){
        if (indices.isEmpty()) return List.of(string);

        List<String> splits = new ArrayList<>();

        List<Integer> sortedIndices = new ArrayList<>(indices);
        sortedIndices.sort(Integer::compare);

        int start = 0;

        for (int i = 0; i < sortedIndices.size(); i++) {
            splits.add(string.substring(start, sortedIndices.get(i)));
            if (sortedIndices.size()-1>i && sortedIndices.get(i).equals(sortedIndices.get(i+1))){
                start = sortedIndices.get(i);
            }else start = sortedIndices.get(i) + 1;
        }

        splits.add(string.substring(start));

        return splits;
    }
}
