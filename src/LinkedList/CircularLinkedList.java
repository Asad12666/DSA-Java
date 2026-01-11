package LinkedList;

import java.util.Objects;

public class CircularLinkedList<T> {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
        }
    }

    public void add(T data){
        Node node = new Node(data);

        if(isEmpty()){
            head = tail = node;
            tail.next = head;
            size++;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void addAll(T ... objects){
        for(T obj : objects){
            add(obj);
        }
    }

    public void addLast(T data){
        add(data);
    }

    public void addFirst(T data){
        Node node = new Node(data);

        if(isEmpty()){
            head = tail = node;
            tail.next = head;
            size++;
            return;
        }

        node.next = head;
        tail.next = node;
        head = node;
        size++;
    }

    public void addAt(int index,T data)throws Exception{
        if(index < 0 || index > size){
            throw new Exception("Index out of bound");
        }

        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size){
            addLast(data);
            return;
        }

        Node node = new Node(data);
        Node temp = head;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public boolean isEmpty(){
        return head == null;
    }
    public int size() {
        return this.size;
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public void remove(T data){
        if(isEmpty()) return;

        if(Objects.equals(head.data, data) && size == 1){
            head = tail = null;
            size = 0;
            return;
        }

        if(Objects.equals(head.data, data)){
            head = head.next;
            tail.next = head;
            size--;
            return;
        }

        Node temp = head;
        while(temp.next != head){
            if (Objects.equals(temp.next.data, data)) {
                if (temp.next == tail) {
                    tail = temp;
                }

                temp.next = temp.next.next;
                tail.next = head;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    public void removeFirst(){
        if(isEmpty()) return;

        if(size == 1){
            head = tail = null;
            size--;
            return;
        }

        head = head.next;
        tail.next = head;
        size--;
    }

    public void removeLast(){
        if(isEmpty()) return;

        if(size == 1){
            head = tail = null;
            size--;
            return;
        }

        Node temp = head;
        for(int i = 0; i < size-2; i++){
            temp = temp.next;
        }

        tail = temp;
        tail.next = head;
        size--;
    }

    public boolean contains(T data){
        if(isEmpty()) return false;

        Node temp = head;
        do{
            if(Objects.equals(temp.data, data)){
                return true;
            }
            temp = temp.next;
        }while(temp != head);

        return false;
    }

    public T get(int index)throws Exception{
        if(index < 0 || index >= size){
            throw new Exception("Index out of bound.");
        }

        if(index == 0){
            return getFirst();
        }
        if(index == size -1){
            return getLast();
        }

        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp.data;
    }

    public T getFirst(){
        return head.data;
    }

    public T getLast(){
        return tail.data;
    }

    @Override
    public String toString(){
        if(isEmpty()) return "[]";

        StringBuilder string = new StringBuilder("[");

        Node temp = head;
        do{
            string.append(temp.data);
            temp = temp.next;
            string.append(" -> ");
        }while(temp != head);
        string.append("(back to head)]");

        return string.toString();
    }

}
