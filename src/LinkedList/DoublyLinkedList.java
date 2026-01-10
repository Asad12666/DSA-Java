package LinkedList;

import java.util.Objects;

public class DoublyLinkedList<T> {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node{

        private T data;
        private Node next;
        private Node prev;

        public Node (T data) {
            this.data = data;
        }

    }


    public void add(T data) { //Method to add Nodes in Doubly LinkedList

        Node node = new Node(data);

        if(isEmpty()) {
            head = tail = node;
            size++;
            return;
        }

        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }

    public void addAll(T ... args) {
        for(T arg : args) {
            add(arg);
        }
    }

    public void addFirst(T data) {
        Node node = new Node(data);

        if(isEmpty()) {
            tail = head = node;
            size++;
            return;
        }

        head.prev = node;
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T data) {
        add(data);
    }

    public void addAt(int index,T data) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index!");
        }

        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size) {
            addLast(data);
            return;
        }

        Node node = new Node(data);

        Node temp = head;
        for(int i = 0; i < index-1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        node.prev = temp;

        temp.next.prev = node;
        temp.next = node;
        size++;
    }


    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void removeFirst() {
        if(isEmpty()) {
            throw new IllegalArgumentException("List is Empty.");
        }

        if(head == tail) { // contain only one node
            head = tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    public void removeLast() {
        if(isEmpty()) {
            throw new IllegalArgumentException("List is Empty.");
        }

        if(head == tail) {
            head = tail = null;
        }else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }

    public void removeAt(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index!");
        }

        if(index == 0) {
            removeFirst();
            return;
        }
        if(index == size-1) {
            removeLast();
            return;
        }

        Node target = head;
        for(int i = 0; i < index; i++) {
            target = target.next;
        }
        Node back = target.prev;
        Node front = target.next;

        target.next = null;
        target.prev = null;

        back.next = front;
        front.prev = back;
        size--;
    }

    public void removeAll(T value) {
        Node temp = head;

        while(temp != null) {
            Node next = temp.next;

            if(Objects.equals(temp.data, value)) {
                if(temp == head) {
                    removeFirst();
                }else if(temp == tail) {
                    removeLast();
                }else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    size--;
                }
            }

            temp = next;
        }
    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid Index!");
        }

        if(index == 0) {
            return getFirst();
        }
        if(index == size - 1) {
            return getLast();
        }

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    public boolean contains(T value) {
        if(isEmpty()) {
            return false;
        }

        Node temp = head;
        for(int i = 0; i < size; i++) {
            if(Objects.equals(temp.data, value)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public int indexOf(T value) {
        if(size == 0) {
            return -1;
        }

        Node temp = head;

        for(int i = 0; i < size; i++) {
            if(Objects.equals(temp.data, value)) {
                return i;
            }
            temp = temp.next;
        }

        return -1;
    }

    public int lastIndexOf(T value) {
        if(size == 0) {
            return -1;
        }

        Node temp = tail;

        for(int i = size-1; i >= 0; i--) {
            if(Objects.equals(temp.data, value)) {
                return i;
            }
            temp = temp.prev;
        }

        return -1;
    }

    public String displayReverse() {
        if(isEmpty()) {
            throw new IllegalArgumentException("List is Empty.");
        }

        StringBuilder string = new StringBuilder();
        Node temp = tail;
        while(temp != null) {
            string.append(temp.data);
            if(temp.prev != null) {
                string.append(" <-> ");
            }
            temp = temp.prev;
        }


        return string.toString();
    }

    public void clear() {
        head = tail = null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node temp = head;

        while(temp != null) {
            string.append(temp.data);
            if(temp.next != null) {
                string.append(" <-> ");
            }
            temp = temp.next;
        }

        return string.toString();
    }

}

