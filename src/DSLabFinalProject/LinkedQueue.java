package DSLabFinalProject;

public class LinkedQueue<T> implements Queue<T> {
    private final CustomLinkedList<T> storage;

    public LinkedQueue() {
        this.storage = new CustomLinkedList<>();
    }

    @Override
    public void enqueue(T data) {
        storage.addLast(data);
    }

    @Override
    public void add(T data) {
        enqueue(data);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("Queue is Empty.");
        return storage.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new IllegalArgumentException("Queue is Empty.");
        return storage.getFirst();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public boolean contains(T data) {
        return storage.contains(data);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}