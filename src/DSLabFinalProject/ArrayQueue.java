package DSLabFinalProject;

public class ArrayQueue<T> implements Queue<T> {
    private Object[] elements;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void resize() {
        Object[] newArr = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = elements[(head + i) % elements.length];
        }
        head = 0;
        tail = size;
        elements = newArr;
    }

    @Override
    public void enqueue(T data) {
        if (size == elements.length) resize();
        elements[tail] = data;
        tail = (tail + 1) % elements.length;
        size++;
    }

    @Override
    public void add(T data) {
        enqueue(data);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("Queue is Empty.");
        T data = (T) elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) throw new IllegalArgumentException("Queue is Empty.");
        return (T) elements[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            Object current = elements[(head + i) % elements.length];
            if (java.util.Objects.equals(data, current)) return true;
        }
        return false;
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        head = tail = size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[(head + i) % elements.length]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}