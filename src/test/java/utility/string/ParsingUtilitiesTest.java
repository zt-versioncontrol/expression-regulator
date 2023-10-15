package utility.string;

import org.junit.jupiter.api.Test;
import utility.structure.Pair;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utility.string.ParsingUtilities.*;

class ParsingUtilitiesTest {

    @Test
    void testFirstDepthOneScopeBoundaries() {
        String simple = "(abc)";  //"(" right and ")" left indicators
        String multiple = "ab(abc)xyz(abc)"; //"(" right and ")" left indicators
        String nested = "ab(((efg)abc)()de)xyz(()abc(lll))"; //"(" right and ")" left indicators
        String empty = ""; //"(" right and ")" left indicators
        String onlyIndicators = "()"; //"(" right and ")" left indicators
        String noClosing = "ab(((efg)abc)()de xyz(()abc(lll))"; //"(" right and ")" left indicators
        String onlyClosing = ")"; //"(" right and ")" left indicators
        String unmatchedClosing = "abcd))))(efgh)"; //"(" right and ")" left indicators
        String longIdicatos = "xxxabcyyy"; //"xxx" right and "yyy" left indicators
        String nestedLongIndicators = "xxxabxxxcyyyyyy"; //"xxx" right and "yyy" left indicators
        String longIndicatorsNoClosing = "123xxxabxxxcyyy"; //"xxx" right and "yyy" left indicators
        String confusedIndicators = "#$abc#$$#$$"; //"#$" right and "#$$" left indicators
        String confusedIndicators2 = "#$abc$#$"; //"#$" right and "$# left" indicators

        Pair<Integer, Integer> scope1 = firstScopeBoundaries(simple, "(", ")");
        Pair<Integer, Integer> scope2 = firstScopeBoundaries(multiple, "(", ")");
        Pair<Integer, Integer> scope3 = firstScopeBoundaries(nested, "(", ")");
        Pair<Integer, Integer> scope4 = firstScopeBoundaries(empty, "(", ")");
        Pair<Integer, Integer> scope5 = firstScopeBoundaries(onlyIndicators, "(", ")");
        Pair<Integer, Integer> scope6 = firstScopeBoundaries(noClosing, "(", ")");
        Pair<Integer, Integer> scope7 = firstScopeBoundaries(onlyClosing, "(", ")");
        Pair<Integer, Integer> scope8 = firstScopeBoundaries(unmatchedClosing, "(", ")");
        Pair<Integer, Integer> scope9 = firstScopeBoundaries(longIdicatos, "xxx", "yyy");
        Pair<Integer, Integer> scope10 = firstScopeBoundaries(nestedLongIndicators, "xxx", "yyy");
        Pair<Integer, Integer> scope11 = firstScopeBoundaries(longIndicatorsNoClosing, "xxx", "yyy");
        Pair<Integer, Integer> scope12 = firstScopeBoundaries(confusedIndicators, "#$", "#$$");
        Pair<Integer, Integer> scope13 = firstScopeBoundaries(confusedIndicators2, "#$", "$#");

        assertEquals(new Pair<>(0, 4), scope1);
        assertEquals(new Pair<>(2, 6), scope2);
        assertEquals(new Pair<>(2, 17), scope3);
        assertEquals(new Pair<>(-1, -1), scope4);
        assertEquals(new Pair<>(0, 1), scope5);
        assertEquals(new Pair<>(2, -1), scope6);
        assertEquals(new Pair<>(-1, -1), scope7);
        assertEquals(new Pair<>(8, 13), scope8);
        assertEquals(new Pair<>(0, 8), scope9);
        assertEquals(new Pair<>(0, 14), scope10);
        assertEquals(new Pair<>(3, -1), scope11);
        assertEquals(new Pair<>(0, -1), scope12);
        assertEquals(new Pair<>(0, 6), scope13);
    }

    @Test
    void testDepthOneScopeBoundaries() {
        String simple = "(abc)"; //"(" right and ")" left indicators
        String nested = "123(abc(efg))xyz(hij)9"; //"(" right and ")" left indicators
        String open = "123(abc"; //"(" right and ")" left indicators
        String multipleAndOpen = "123(abc)567(xyz(mno()"; //"(" right and ")" left indicators
        String empty = ""; //"(" right and ")" left indicators
        String openAndNested = "ab(((efg)abc)()de xyz(()abc(lll))"; //"(" right and ")" left indicators
        String longIndicators = "xxxabcyyy"; //"xxx" right and "yyy" left indicators
        String nestedLongIndicators = "xxxabxxxcyyyyyy"; //"xxx" right and "yyy" left indicators
        String confusedIndicators1 = "123xxxabxxxcyyyyy"; //"xxx" right and "yyy" left indicators
        String confusedIndicators2 = "#$abc#$$ 321#$$"; //"#$" right and "#$$" left indicators
        String confusedIndicators3 = "#$abc$#$123$##$"; //"#$" right and "$# left" indicators

        List<Pair<Integer, Integer>> scope1 = scopeBoundaries(simple, "(", ")");
        List<Pair<Integer, Integer>> scope2 = scopeBoundaries(nested, "(", ")");
        List<Pair<Integer, Integer>> scope3 = scopeBoundaries(open, "(", ")");
        List<Pair<Integer, Integer>> scope4 = scopeBoundaries(multipleAndOpen, "(", ")");
        List<Pair<Integer, Integer>> scope5 = scopeBoundaries(empty, "(", ")");
        List<Pair<Integer, Integer>> scope6 = scopeBoundaries(openAndNested, "(", ")");
        List<Pair<Integer, Integer>> scope7 = scopeBoundaries(longIndicators, "xxx", "yyy");
        List<Pair<Integer, Integer>> scope8 = scopeBoundaries(nestedLongIndicators, "xxx", "yyy");
        List<Pair<Integer, Integer>> scope9 = scopeBoundaries(confusedIndicators1, "xxx", "yyy");
        List<Pair<Integer, Integer>> scope10 = scopeBoundaries(confusedIndicators2, "#$", "#$$");
        List<Pair<Integer, Integer>> scope11 = scopeBoundaries(confusedIndicators3, "#$", "$#");

        assertIterableEquals(List.of(new Pair<>(0, 4)), scope1);
        assertIterableEquals(List.of(new Pair<>(3, 12), new Pair<>(16, 20)), scope2);
        assertIterableEquals(List.of(new Pair<>(3, -1)), scope3);
        assertIterableEquals(List.of(new Pair<>(3, 7), new Pair<>(11, -1)), scope4);
        assertIterableEquals(List.of(), scope5);
        assertIterableEquals(List.of(new Pair<>(2, -1)), scope6);
        assertIterableEquals(List.of(new Pair<>(0, 8)), scope7);
        assertIterableEquals(List.of(new Pair<>(0, 14)), scope8);
        assertIterableEquals(List.of(new Pair<>(3, -1)), scope9);
        assertIterableEquals(List.of(new Pair<>(0, -1)), scope10);
        assertIterableEquals(List.of(new Pair<>(0, 6), new Pair<>(13, -1)), scope11);
    }



    @Test
    void testSymmetricScopeBoundaries() {
        String expression1 = "\"abcd\"\"\",lmno\"z\"\"lll";
        String expression2 = "abc^& efg ^& hij^&^&^&^";

        List<Pair<Integer, Integer>> scopes1 = symmetricScopeBoundaries(expression1, "\"");
        List<Pair<Integer, Integer>> scope2 = symmetricScopeBoundaries(expression2, "^&");

        assertIterableEquals(List.of(new Pair<>(0,5), new Pair<>(6, 7), new Pair<>(13, 15), new Pair<>(16, -1)), scopes1);
        assertIterableEquals(List.of(new Pair<>(3, 11), new Pair<>(16, 19), new Pair<>(20, -1)), scope2);
    }

    @Test
    void testIndexSplit() {
        String s = "1234567890abcdef1234567890abcdef";

        List<Integer> simple = List.of(3, 5, 10, 18);
        List<Integer> unsorted = List.of( 14, 5, 3, 10, 2, 19);
        List<Integer> adjacent = List.of(0, 1, 2, 3, 4, 5);
        List<Integer> empty = List.of();
        List<Integer> edgges = List.of(0, 4, 13, 31);
        List<Integer> repeated = List.of(3,3,3,3, 10);
        List<Integer> negative = List.of(-5, 3);
        List<Integer> outOfRange = List.of(5, 58, 9);
        List<Integer> outOfRange2 = List.of(32);

        assertIterableEquals(List.of("123", "5", "7890", "bcdef12", "4567890abcdef"), indexSplit(s, simple));
        assertIterableEquals(List.of("12", "", "5", "7890", "bcd", "f123", "567890abcdef"), indexSplit(s, unsorted));
        assertIterableEquals(List.of("", "", "", "", "", "", "7890abcdef1234567890abcdef"), indexSplit(s, adjacent));
        assertIterableEquals(List.of("1234567890abcdef1234567890abcdef"), indexSplit(s, empty));
        assertIterableEquals(List.of("", "234", "67890abc", "ef1234567890abcde", ""), indexSplit(s, edgges));
        assertIterableEquals(List.of("123", "", "", "", "567890", "bcdef1234567890abcdef"), indexSplit(s, repeated));
        assertThrows(RuntimeException.class, () -> indexSplit(s, negative));
        assertThrows(RuntimeException.class, () -> indexSplit(s, outOfRange));
        assertThrows(RuntimeException.class, () -> indexSplit(s, outOfRange2));
    }
}