package DSLabFinalProject;

import java.util.Objects;

public class LinkedDeque<T> implements Deque<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void addFirst(T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new IllegalArgumentException("Deque is Empty.");
        T removed = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removed;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new IllegalArgumentException("Deque is Empty.");
        T removed = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removed;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) throw new IllegalArgumentException("Deque is Empty.");
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new IllegalArgumentException("Deque is Empty.");
        return tail.data;
    }

    @Override
    public void enqueue(T data) {
        addLast(data);
    }

    @Override
    public T dequeue() {
        return removeFirst();
    }

    @Override
    public T peek() {
        return getFirst();
    }

    @Override
    public void add(T data) {
        addLast(data);
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
        Node temp = head;
        while (temp != null) {
            if (Objects.equals(temp.data, data)) return true;
            temp = temp.next;
        }
        return false;
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
            string.append(temp.data);
            if (temp.next != null) string.append(" <-> ");
            temp = temp.next;
        }
        return string.toString();
    }
}