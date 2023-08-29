package utility;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class RevertibleTest {

    @Test
    void update() {
        Supplier<List<Integer>> defaultStateSupplier = () -> List.of(1,2);
        Revertible<List<Integer>> revertible = new Revertible<>(defaultStateSupplier);

        assertEquals(defaultStateSupplier.get(), revertible.get());

        List<Integer> secondList = List.of(3,4);
        revertible.update(secondList);

        assertEquals(secondList, revertible.get());
        assertThrowsExactly(Revertible.RepeatedStateException.class, () -> revertible.update(secondList));
        assertThrowsExactly(Revertible.RepeatedStateException.class, () -> revertible.update(defaultStateSupplier.get()));
    }

    @Test
    void revert() {
        Supplier<String> defaultStateSupplier = () -> "string1";
        String s2 = "string2";
        String s3 = "string3";

        Revertible<String> revertible = new Revertible<>(defaultStateSupplier);
        revertible.update(s2);
        revertible.update(s3);

        assertEquals(s3, revertible.get());
        revertible.revert();
        assertEquals(s2, revertible.get());
        revertible.revert();
        assertEquals(defaultStateSupplier.get(), revertible.get());
        assertThrowsExactly(Revertible.NoPreviousStateException.class, revertible::revert);


    }

    @Test
    void reset() {


        Revertible<Integer> revertible = new Revertible<>(() -> 1);

        revertible.reset();
        assertEquals(1, revertible.get());

        revertible.update(2);
        revertible.update(3);
        revertible.revert();
        revertible.update(4);
        revertible.reset();

        assertEquals(1, revertible.get());
    }
}