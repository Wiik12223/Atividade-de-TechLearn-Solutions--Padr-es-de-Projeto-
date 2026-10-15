package techlearn.iterator;

public final class NullIterator<T> implements Iterator<T> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
