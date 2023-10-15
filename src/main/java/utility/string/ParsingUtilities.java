package utility.string;

import utility.structure.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParsingUtilities {
    private ParsingUtilities() {}

    //returns (-1, -1) if no scope was found
    //returns (index, -1) if closing scope was not found
    //ignores scope closing indicators if they were not preceded by opening indicators
    public static Pair<Integer, Integer> firstScopeBoundaries(String expression, String leftIndicator, String rightIndicator){
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

    //includes unbound scopes (scopes without end indicator) in the form (index, -1)
    //maximum of 1 unbound scope and must last element the of returned list
    //returns empty list if no scopes were found
    //ignores scope closing indicators if they were not preceded by opening indicators
    public static List<Pair<Integer, Integer>> scopeBoundaries(String expression, String startIndicator, String endIndicator){
        List<Pair<Integer, Integer>> scopeBoundaries = new ArrayList<>();
        Pair<Integer, Integer> nextScopeBoundaries = firstScopeBoundaries(expression, startIndicator, endIndicator);
        int offset = 0;
        while (nextScopeBoundaries.first != -1){
            scopeBoundaries.add(
                    new Pair<>(nextScopeBoundaries.first + offset,
                            nextScopeBoundaries.second == -1? -1 : nextScopeBoundaries.second + offset)
            );

            if (nextScopeBoundaries.second != -1) {
                expression = expression.substring(nextScopeBoundaries.second + 1);
                offset += nextScopeBoundaries.second + 1;
                nextScopeBoundaries = firstScopeBoundaries(expression, startIndicator, endIndicator);
            }else {
                break;
            }
        }

        return scopeBoundaries;
    }


    public static List<Pair<Integer, Integer>> noneIntersectedScopeBoundaries(String expression,
                                                                              List<Pair<String, String>> scopeIndicators,
                                                                              List<String> symmetricScopeIndicators)
    {
        List<Pair<Integer, Integer>> independentScopes = new ArrayList<>();
        List<Pair<Integer, Integer>> nonIntersectedScopes = new ArrayList<>();

        for (Pair<String, String> scopeIndicator : scopeIndicators) {
            independentScopes.addAll(scopeBoundaries(expression, scopeIndicator.first, scopeIndicator.second));
        }
        for (String symmetricScopeIndicator : symmetricScopeIndicators) {
            independentScopes.addAll(symmetricScopeBoundaries(expression, symmetricScopeIndicator));
        }

        independentScopes.sort(Comparator.comparingInt(scope -> scope.first));
        for (int i = 0; i < independentScopes.size(); i++) {
            Pair<Integer, Integer> scopeInCheck = independentScopes.get(i);
            //the first scope in the sorted list is always taken, the following scope is taken if it does not intersect with the previous scope and so on
            nonIntersectedScopes.add(scopeInCheck);

            //if the scope is unbound all following scopes are discarded
            if ((scopeInCheck.second == -1) || (i == independentScopes.size()-1)) return independentScopes;
            //if current scope does not intersect with next scope restart the loop,
            if (scopeInCheck.second <  independentScopes.get(i+1).first) continue;

            //if current scope intersect with next scope, find scopes again for section of expression after current scope, recur, then terminated loop
            Integer offset = scopeInCheck.second+1;
            List<Pair<Integer, Integer>> remainingScopes = noneIntersectedScopeBoundaries(expression.substring(offset), scopeIndicators, symmetricScopeIndicators);
            //restore the correct indices to compensate for substring() call
            for (Pair<Integer, Integer> remainingScope : remainingScopes) {
                nonIntersectedScopes.add(new Pair<>(remainingScope.first+offset, remainingScope.second==-1? -1 : remainingScope.second+offset));
            }
            return nonIntersectedScopes;
        }
        return nonIntersectedScopes;
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
