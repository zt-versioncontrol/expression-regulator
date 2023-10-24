package utility.string;

import utility.structure.Pair;

import java.util.List;

// TODO: 10/17/2023 write unit tests for all methods
public class ManipulationUtilities {
    //replace all consecutive characters selected by a character selector with a replacementString
    public static String foldCharacters(String expression, CharacterSelector characterSelector, String replacement){
        StringBuilder folded = new StringBuilder();

        boolean isConsecutive = false;

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (characterSelector.isSelected(current)){
                if (!isConsecutive){
                    folded.append(replacement);
                    isConsecutive = true;
                }
            }else{
                folded.append(current);
                isConsecutive = false;
            }
        }

        return folded.toString();
    }

    //replace all scopes within given scope indicators, including indicators,  with a replacement string
    public static String foldScopes(String expression, String startIndicator, String endIndicator, String replacement){
        StringBuilder folded = new StringBuilder();

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.scopeBoundaries(expression, startIndicator, endIndicator);

        int start = 0;
        for (Pair<Integer, Integer> scope : scopes) {
            folded.append(expression.substring(start, scope.first));
            folded.append(replacement);
            start = scope.second+1;
        }

        return folded.toString();
    }

    //replace all symmetric scopes within given scope indicators, including indicators,  with a replacement string
    public static String foldSymmetricScopes(String expression, String scopeIndicators, String replacement){
        StringBuilder folded = new StringBuilder();

        List<Pair<Integer, Integer>> scopes = ParsingUtilities.symmetricScopeBoundaries(expression, scopeIndicators);

        int start = 0;
        for (Pair<Integer, Integer> scope : scopes) {
            folded.append(expression.substring(start, scope.first));
            folded.append(replacement);
            start = scope.second+1;
        }

        return folded.toString();
    }

    //remove all characters after given indicator
    //removes the indicator if inclusive is true
    public static String cutAfter(String string, String indicator, boolean inclusive){
        int indicatorIndex = string.indexOf(indicator);
        if (indicatorIndex == -1) return string;

        int cutIndex = inclusive? indicatorIndex : indicatorIndex + indicator.length();
        return string.substring(0, cutIndex);
    }

    //remove all characters before given indicator
    //removes the indicator if inclusive is true
    public static String cutBefore(String string, String indicator, boolean inclusive){
        int indicatorIndex = string.indexOf(indicator);
        if (indicatorIndex == -1) return string;

        int startIndex = inclusive? indicatorIndex+indicator.length() : indicatorIndex;
        return string.substring(startIndex);
    }





    public interface CharacterSelector{
        boolean isSelected(Character character);
    }
}
