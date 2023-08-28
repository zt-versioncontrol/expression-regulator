package utility;

import java.util.ArrayDeque;
import java.util.HashSet;

public class Revertible<T> {
    private final T defaultState;
    private T current;
    private final ArrayDeque<T> history = new ArrayDeque<>();
    private final HashSet<T> uniquenessValidator = new HashSet<>();


    public Revertible(T current) {
        this.current = current;
        defaultState = current;
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
        current = defaultState;
        history.clear();
        uniquenessValidator.clear();
        uniquenessValidator.add(defaultState);
    }


    public static class RepeatedStateException extends RuntimeException{}
    public static class NoPreviousStateException extends RuntimeException{}
}
