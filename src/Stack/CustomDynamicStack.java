package Stack;

import java.util.Arrays;

public class CustomDynamicStack<T> {
    protected Object[] data;
    public static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomDynamicStack(int initialCapacity){
        this.data = new Object[initialCapacity];
    }
    public CustomDynamicStack(){
        this(DEFAULT_SIZE);
    }

    public void push(T element){
        if (isFull()){
            resize();
        }

        data[size++] = element;
    }

    public void pushMultiple(T ... values){
        while (size + values.length > data.length){
            resize();
        }

        for (T val : values){
            push(val);
        }
    }

    public T peek()throws StackException{
        if (isEmpty()){
            throw new StackException("Empty Stack: cannot peek.");
        }

        return (T) data[size - 1];
    }

    public T pop()throws StackException{
        if (isEmpty()){
            throw new StackException("Empty Stack: cannot pop.");
        }

        @SuppressWarnings("unchecked")
        T removed = (T) data[--size];
        data[size] = null;
        return removed;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return data.length == size;
    }
    public int capacity(){
        return data.length;
    }
    public int size(){
        return size;
    }

    private void resize(){
        int oldCapacity = data.length;
        int newCapacity = data.length * 2;
        Object[] temp = new Object[newCapacity];

        System.arraycopy(data,0,temp,0,oldCapacity);
        data = temp;
    }

    public boolean contains(T element){
        if (isEmpty()) return false;

        for (int i = 0; i < size; i++){
            if (data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public void displayReverse(){
        System.out.print("Reversed Stack: ");
        for (int i = size-1; i >= 0; i--){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public void clear(){
        for (int i = 0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }

    public void trimToSize(){
        if (data.length > size){
            data = Arrays.copyOf(data, size);
        }
    }

    public Object[] toArray(){
        return Arrays.copyOf(data,size);
    }

    public boolean isResizeable(){
        return true;
    }

    public int search(T element){
        for (int i = size - 1, position = 1; i >= 0; i--,position++){
            if (data[i].equals(element)){
                return position;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOfRange(data,0,size));
    }
}
