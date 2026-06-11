package DSLabFinalProject;

public interface Queue<T> extends Collection<T> {
    void enqueue(T data);
    T dequeue();
    T peek();
}