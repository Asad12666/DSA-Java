package DataStructures;


import java.util.Collection;

public class MyStack<T> {
    //In this project we are going to design a dynamic stack using array and linked list.
    private T[] arr;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity){
        if(initialCapacity <= 0){
            throw new StackException("Initial capacity must be greater than 0");
        }
        arr = (T[])new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public T top(){
        return arr[size-1];
    }

    public void push(T value){
        if(value == null){
            throw new StackException("Null is not allowed");
        }
        if(isFull()){
            resize();
        }
        arr[size] = value;
        size++;
    }

    public T peek(){
        if(isEmpty()){
            throw new StackException("Stack is Empty");
        }

        return arr[size - 1];
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = arr.length * 2;
        T[] newArr = (T[])new Object[newCapacity];

        for(int i = 0; i < size; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public T pop(){
        if(isEmpty()){
            throw new StackException("Stack is Empty.");
        }

        T value = arr[--size];
        arr[size] = null;

        return value;
    }

    @SafeVarargs
    public final void pushAll(T ... args){
        for(T arg : args){
            push(arg);
        }
    }

    public void pushAll(Collection<? extends T> collection){
        for(T element : collection){
            push(element);
        }
    }

    public boolean isFull(){
        return arr.length == size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        for(int i = 0; i < size; i++){
            arr[i] = null;
        }

        size = 0;
    }

    public boolean contains(T element){
        for(int i = 0; i < size; i++){
            if(arr[i] != null && arr[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void trimToSize(){
        if(size == arr.length) return;

        T[] newArr = (T[]) new Object[size];
        System.arraycopy(arr, 0, newArr, 0, size);

        arr = newArr;
    }

    //This method returns the 1 based position from the top of the stack.
    public int search(T element){
        for(int i = size - 1, pos = 1; i >= 0; i--,pos++){
            if(arr[i].equals(element)){
                return pos;
            }
        }

        return -1;
    }

    public int capacity(){
        return arr.length;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(){
        T[] result = (T[])new Object[size];
        System.arraycopy(arr, 0, result, 0, size);
        return result;
    }

    public void reverse(){
        int left = 0;
        int right = size - 1;

        while(left < right){
            T temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    //This creates deep copy of stack and return it to the user.
    public MyStack<T> clone(){
        MyStack<T> newStack = new MyStack<>(arr.length);

        for(int i = 0; i < size; i++){
            newStack.push(arr[i]);
        }

        return newStack;
    }

    @SuppressWarnings("unchecked")
    public T[] popMultiple(int k){
        if(k <= 0){
            throw new StackException("Not enough elements.");
        }
        if(k > size){
            throw new StackException("Not enough elements in stack.");
        }

        T[] result = (T[])new Object[k];
        for(int i = 0; i < k; i++){
            result[i] = pop();
        }

        return result;
    }

    public void swapTop(){
        if(size < 2){
            throw new StackException("Not enough elements.");
        }

        T temp = arr[size-1];
        arr[size - 1] = arr[size - 2];
        arr[size - 2] = temp;
    }

    @Override
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0; i < size; i++){
            str.append(arr[i]);
            if(i == size-1){
                str.append("]");
                break;
            }
            str.append(", ");
        }

        return str.toString();
    }
}