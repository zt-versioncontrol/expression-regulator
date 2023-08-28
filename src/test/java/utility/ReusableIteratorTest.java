package utility;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReusableIteratorTest {



    @Test
    void reset() {
        List<Integer> integers = List.of(1,3,4,5,6,7,8);
        ReusableIterator<Integer> iterator = new ReusableIterator<>(integers.iterator());

        iterator.reset();
        assertNull(iterator.getIterated());

        iterator.next();
        iterator.next();

        assertNotNull(iterator.getIterated());
        iterator.reset();
        assertNull(iterator.getIterated());
    }


    @Test
    void next() {
        List<Integer> integers = List.of(1,2,3,4,5);
        ReusableIterator<Integer> iterator = new ReusableIterator<>(integers.iterator());

        assertTrue(iterator.next());
        assertEquals(1, iterator.getIterated());
        assertTrue(iterator.next());
        assertTrue(iterator.next());
        assertEquals(3, iterator.getIterated());

        assertTrue(iterator.next());
        assertTrue(iterator.next());

        assertNotNull(iterator.getIterated());
        assertFalse(iterator.next());
        assertNull(iterator.getIterated());
        assertFalse(iterator.next());
        assertNull(iterator.getIterated());

        iterator = new ReusableIterator<>(new ArrayList<Integer>().iterator());
        assertFalse(iterator.next());
    }

    @Test
    void filterRemaining() {
        List<String> strings = List.of("a1", "a2", "b1","b3", "ab5", "ac2", "ba32", "bc1");
        ReusableIterator<String> iterator = new ReusableIterator<>(strings.iterator());


        iterator.next();
        iterator.next();

        iterator.filterRemaining(s -> s.startsWith("a"));
        assertNull(iterator.getIterated());
        iterator.next();
        assertEquals("ab5", iterator.getIterated());
        iterator.next();
        assertEquals("ac2", iterator.getIterated());
        iterator.next();
        assertNull(iterator.getIterated());

        iterator.filterRemaining(s -> true);
        iterator.next();
        assertNull(iterator.getIterated());

        iterator = new ReusableIterator<>(new ArrayList<String>().iterator());
        iterator.filterRemaining(s -> true);
        iterator.next();
        assertNull(iterator.getIterated());


    }

    @Test
    void resetAndFilter() {
        List<String> strings = List.of("z", "a1", "a2", "b1","b3", "ab5", "ac2", "ba32", "bc1");
        ReusableIterator<String> iterator = new ReusableIterator<>(strings.iterator());


        iterator.next();
        iterator.next();

        iterator.resetAndFilter(s -> s.startsWith("a"));
        assertNull(iterator.getIterated());
        iterator.next();
        assertEquals("a1", iterator.getIterated());
        iterator.next();
        assertEquals("a2", iterator.getIterated());
        iterator.next();
        assertEquals("ab5", iterator.getIterated());
        iterator.next();
        assertEquals("ac2", iterator.getIterated());
        iterator.next();
        assertNull(iterator.getIterated());


        iterator.resetAndFilter(s -> true);
        assertNull(iterator.getIterated());
        iterator.next();
        assertEquals("z", iterator.getIterated());


        iterator = new ReusableIterator<>(new ArrayList<String>().iterator());
        iterator.resetAndFilter(s -> true);
        iterator.next();
        assertNull(iterator.getIterated());

    }
}