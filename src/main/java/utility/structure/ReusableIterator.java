package utility.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ReusableIterator<T> {
    private List<T> iteratorSource = new ArrayList<>();
    private Iterator<T> iterator;
    private T iterated = null;

    public ReusableIterator(Iterator<T> iterator) {
        iterator.forEachRemaining(iteratorSource::add);
        this.iterator = iteratorSource.iterator();
    }

    public T getIterated(){
        return iterated;
    }

    public void reset(){
        iterated = null;
        iterator = iteratorSource.iterator();
    }

    public boolean hasNext(){
        return iterator.hasNext();
    }

    public boolean next(){
        boolean hasNext = iterator.hasNext();

        if (hasNext) iterated = iterator.next();
        else iterated = null;

        return hasNext;
    }

    public void filterRemaining(Predicate<T> filteringPredicate){
        iterated = null;
        List<T> filtered = new ArrayList<>();
        if (iterator.hasNext()){

            iterator.forEachRemaining(t -> {
                if (filteringPredicate.test(t)) filtered.add(t);
            });
        }
        iterator = filtered.iterator();
    }

    public void resetAndFilter(Predicate<T> filteringPredicate){
        reset();
        filterRemaining(filteringPredicate);
    }
}
