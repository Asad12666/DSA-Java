package DSLabFinalProject;

public interface Deque<T> extends Queue<T> {
    void addFirst(T data);
    void addLast(T data);
    T removeFirst();
    T removeLast();
    T getFirst();
    T getLast();
}