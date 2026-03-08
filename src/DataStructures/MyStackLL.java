package DataStructures;

import java.util.*;

public class MyStackLL <T extends Comparable<T>>{
    Node head;
    private int size = 0;

    public MyStackLL(){
        this.size = 0;
    }

    private class Node{
        T data;
        Node next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(T element){
        Node node = new Node(element);
        node.next = head;
        head = node;
        size++;
    }


    public void pushAll(T... args){
        for(T arg : args){
            push(arg);
        }
    }

    public void pushAll(Collection<? extends T> collection){
        for(T obj : collection){
            push(obj);
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return this.size;
    }

    public T peek(){
        if(isEmpty()){
            throw new StackException("Stack is Empty.");
        }

        return head.data;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public T pop(){
        if(isEmpty()){
            throw new StackException("Stack is Empty.");
        }

        T popValue = head.data;
        head = head.next;
        size--;
        return popValue;
    }

    public List<T> pop(int k){
        if(k > size){
            throw new StackException("Not enough elements.");
        }

        List<T> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            list.add(pop());
        }

        return list;
    }

    public boolean contains(T element){
        Node temp = head;
        while(temp != null){
            if(temp.data.equals(element)){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(){
        if(isEmpty()){
            return (T[])new Object[]{};
        }

        T[] result = (T[]) new Object[size];
        Node temp = head;
        for(int i = 0; i < size; i++){
            result[i] = temp.data;
            temp = temp.next;
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public void sort(){
        List<T> list = new ArrayList<>();
        Node temp = head;

        while(temp != null){
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);

        clear();

        for(int i = list.size() - 1; i >= 0; i--){
            push(list.get(i));
        }
    }

    public MyStackLL<T> clone(){
        MyStackLL<T> tempStack = new MyStackLL<>();
        MyStackLL<T> newStack = new MyStackLL<>();

        Node temp = head;

        while(temp != null){
            tempStack.push(temp.data);
            temp = temp.next;
        }

        while(!tempStack.isEmpty()){
            newStack.push(tempStack.pop());
        }

        return newStack;
    }

    @Override
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node temp = head;
        while(temp != null){
            str.append(temp.data);
            if(temp.next != null){
                str.append(", ");
            }
            temp = temp.next;
        }
        str.append("]");

        return new String(str);
    }
}