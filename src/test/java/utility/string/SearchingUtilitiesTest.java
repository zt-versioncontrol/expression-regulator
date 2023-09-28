package utility.string;

import org.junit.jupiter.api.Test;
import utility.structure.Pair;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utility.string.SearchingUtilities.*;

class SearchingUtilitiesTest {

    @Test
    void testIndicesOf() {
        String s1 = ",ab,cd,e,,,fg,12345,67,";
        String s2 = "$$$a$$b$$$$c$$$$$de$f$g123456$$";

        assertIterableEquals(List.of(0, 3, 6, 8, 9, 10, 13, 19, 22), indicesOf(s1, ","));
        assertIterableEquals(List.of(0, 4, 7, 9, 12, 14, 29), indicesOf(s2, "$$"));
    }

    @Test
    void testUnscopedIndicesOf(){
        String expression1 = ",23,56,8901,345,7,90,";

        List<Pair<Integer, Integer>> interleaved = List.of(new Pair<>(0, 5), new Pair<>(2, 6), new Pair<>(9, 10), new Pair<>(18, 19));
        List<Pair<Integer, Integer>> unsorted = List.of(new Pair<>(9, 10), new Pair<>(0, 5), new Pair<>(18, 19), new Pair<>(2, 6));
        List<Pair<Integer, Integer>> openFromRight = List.of(new Pair<>(0, -1), new Pair<>(3,5));
        List<Pair<Integer, Integer>> openFromRight2 = List.of(new Pair<>(1, -1));
        List<Pair<Integer, Integer>> inclusive = List.of(new Pair<>(0, 20));
        List<Pair<Integer, Integer>> nearEdge = List.of(new Pair<>(1, 19));
        List<Pair<Integer, Integer>> invertedScope = List.of(new Pair<>(5, 4));
        List<Pair<Integer, Integer>> invertedScope2 = List.of(new Pair<>(5, 4), new Pair<>(0, 15));
        List<Pair<Integer, Integer>> shortt = List.of(new Pair<>(0, 0));
        List<Pair<Integer, Integer>> outOfRange = List.of(new Pair<>(100, 101));
        List<Pair<Integer, Integer>> empty = List.of();
        List<Pair<Integer, Integer>> negative = List.of(new Pair<>(-1, 15));


        unscopedIndecisOf(expression1, interleaved, ",");

        assertIterableEquals(List.of(11, 15, 17, 20), unscopedIndecisOf(expression1, interleaved, ","));
        assertIterableEquals(List.of(11, 15, 17, 20), unscopedIndecisOf(expression1, unsorted, ","));
        assertIterableEquals(List.of(), unscopedIndecisOf(expression1, openFromRight, ","));
        assertIterableEquals(List.of(0), unscopedIndecisOf(expression1, openFromRight2, ","));
        assertIterableEquals(List.of(), unscopedIndecisOf(expression1, inclusive, ","));
        assertIterableEquals(List.of(0, 20), unscopedIndecisOf(expression1, nearEdge, ","));
        assertIterableEquals(List.of(0, 3, 6, 11, 15, 17, 20), unscopedIndecisOf(expression1, invertedScope, ","));
        assertIterableEquals(List.of(17, 20), unscopedIndecisOf(expression1, invertedScope2, ","));
        assertIterableEquals(List.of(3, 6, 11, 15, 17, 20), unscopedIndecisOf(expression1, shortt, ","));
        assertIterableEquals(List.of(0, 3, 6, 11, 15, 17, 20), unscopedIndecisOf(expression1, outOfRange, ","));
        assertIterableEquals(List.of(0, 3, 6, 11, 15, 17, 20), unscopedIndecisOf(expression1, empty, ","));
        assertIterableEquals(List.of(17, 20), unscopedIndecisOf(expression1, negative, ","));
    }
}