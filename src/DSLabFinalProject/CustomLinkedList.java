package DSLabFinalProject;

import java.util.Objects;

public class CustomLinkedList<T> implements List<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T data) {
        addLast(data);
    }

    @SafeVarargs
    public final void add(T... args) {
        for (T arg : args) {
            add(arg);
        }
    }

    public void addFirst(T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node temp = getNode(index - 1);
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    public T getFirst() {
        if (isEmpty()) throw new IllegalArgumentException("List is Empty.");
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) throw new IllegalArgumentException("List is Empty.");
        return tail.data;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public void set(int index, T data) {
        Node temp = getNode(index);
        temp.data = data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalArgumentException("List is Empty.");
        T removed = head.data;
        head = head.next;
        size--;
        if (isEmpty()) tail = null;
        return removed;
    }

    public T removeLast() {
        if (isEmpty()) throw new IllegalArgumentException("List is Empty.");
        if (size == 1) return removeFirst();

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        T removed = tail.data;
        tail = temp;
        tail.next = null;
        size--;
        return removed;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node temp = getNode(index - 1);
        T removed = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return removed;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    @Override
    public int indexOf(T data) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data, temp.data)) return i;
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        Node temp = head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data, temp.data)) index = i;
            temp = temp.next;
        }
        return index;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            string.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        string.append("null");
        return string.toString();
    }
}