package DSLabFinalProject;

public class Stack<T> {
    private final List<T> list;

    public Stack() {
        this.list = new CustomArrayList<>();
    }

    public void push(T data) {
        list.add(data);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalArgumentException("Stack is Empty.");
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new IllegalArgumentException("Stack is Empty.");
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}