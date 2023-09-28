package utility.structure;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.function.Supplier;

public class Revertible<T> {
    private final Supplier<T> defaultStateSupplier;
    private T current;
    private final ArrayDeque<T> history = new ArrayDeque<>();
    private final HashSet<T> uniquenessValidator = new HashSet<>();


    public Revertible(Supplier<T> defaultStateSupplier) {
        this.defaultStateSupplier = defaultStateSupplier;
        this.current = this.defaultStateSupplier.get();
        uniquenessValidator.add(current);
    }

    public T get(){
        return current;
    }

    public void update(T newState) throws RepeatedStateException{
        if (uniquenessValidator.contains(newState)) throw new RepeatedStateException();

        history.addLast(current);
        current = newState;
        uniquenessValidator.add(newState);
    }

    public void revert() throws NoPreviousStateException{
        if (history.isEmpty()) throw new NoPreviousStateException();

        T last = history.removeLast();
        uniquenessValidator.remove(current);
        current = last;
    }

    public void reset(){
        current = defaultStateSupplier.get();
        history.clear();
        uniquenessValidator.clear();
        uniquenessValidator.add(current);
    }


    public static class RepeatedStateException extends RuntimeException{}
    public static class NoPreviousStateException extends RuntimeException{}
}
