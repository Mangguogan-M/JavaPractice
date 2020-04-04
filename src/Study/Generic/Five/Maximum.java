package Study.Generic.Five;

public interface Maximum<T extends Comparable<T>> {
    T getMax(T[] array);
}
