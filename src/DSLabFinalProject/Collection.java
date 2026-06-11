package DSLabFinalProject;

public interface Collection<T> {
    void add(T data);
    int size();
    boolean isEmpty();
    boolean contains(T data);
    void clear();
}