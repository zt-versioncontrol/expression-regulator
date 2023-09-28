package utility.structure;

public class Pair<T1, T2> {
    public final T1 first;
    public final T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair other){
            return first.equals(other.first) && second.equals(other.second);
        }

        return false;
    }
}
