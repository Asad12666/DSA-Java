package Generics;

import java.util.Arrays;

public class CustomDynamicArrayList<T> {

    protected Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;


    public CustomDynamicArrayList(int initialCapacity){
        this.data = new Object[initialCapacity];
    }

    public CustomDynamicArrayList(){
        this(DEFAULT_SIZE);
    }


    public int size(){
        return size;
    }

    public int capacity(){
        return data.length;
    }

    @SuppressWarnings("unchecked")
    public T getElementAtIndex(int index)throws ArrayListException{
        if (isEmpty()){
            throw new ArrayListException("ArrayList is Empty.");
        }
        if (index < 0 || index >= size){
            throw new ArrayListException("Invalid Index!.");
        }
        return (T)data[index];
    }

    @SuppressWarnings("unchecked")
    public T getFirst() throws ArrayListException{
        if (isEmpty()){
            throw new ArrayListException("ArrayList is Empty.");
        }
        return (T)data[0];
    }

    @SuppressWarnings("unchecked")
    public T get(int index)throws ArrayListException{
        if (index < 0 || index >= size){
            throw new ArrayListException("Invalid Index!.");
        }

        return (T)data[index];
    }

    @SuppressWarnings("unchecked")
    public T getLast()throws ArrayListException{
        if (isEmpty()){
            throw new ArrayListException("ArrayList is Empty.");
        }
        return (T)data[size-1];
    }

    public void add(T element){
        if (isFull()){
            grow();
        }
        data[size++] = element;
    }

    public void add(int index,T element)throws ArrayListException{
        if (index < 0 || index > size){
            throw new ArrayListException("Invalid Index!");
        }

        if (isFull()) grow();
        if (index == 0){
            addFirst(element);
            return;
        }
        if (index == size){
            addLast(element);
            return;
        }

        for (int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public void addAll(T ... args){
        ensureCapacity(size + args.length);
        for (T obj : args){
            add(obj);
        }
    }

    public void addFirst(T element){
        if (isFull()){
            grow();
        }

        for (int i = size - 1; i >= 0; i--){
            data[i+1] = data[i];
        }
        data[0] = element;
        size++;
    }

    public void addLast(T element){
        if (isFull()){
            grow();
        }
        data[size++] = element;
    }

    public void removeLast(){
        if (isEmpty()) return;
        data[size-1] = null;
        size--;
    }

    public void removeFirst(){
        if (isEmpty()) return;

        for (int i = 0; i < size-1; i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
    }

    public void removeByIndex(int index)throws ArrayListException{
        if (index < 0 || index >= size){
            throw new ArrayListException("Invalid Index!.");
        }
        if (index == 0){
            removeFirst();
            return;
        }
        if (index == size-1){
            removeLast();
            return;
        }

        for (int i = index; i < size-1; i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
    }

    public boolean isFull(){
        return data.length == size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void grow(){
        int oldCapacity = data.length;
        int newCapacity = oldCapacity == 0 ? 1: data.length + (data.length / 2);
        Object[] temp = new Object[newCapacity];

        System.arraycopy(data,0,temp,0,oldCapacity);
        data = temp;
    }

    public boolean contains(T element){
        for (int i = 0; i < size; i++){
            if (data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        if (isEmpty()) return;
        for (int i = 0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public T set(T element,int index)throws ArrayListException{
        if (index < 0 || index >= size) {
            throw new ArrayListException("Invalid Index: index out of bound " + index + " for size " + size);
        }

        Object previousValue = data[index];
        data[index] = element;
        return (T)previousValue;
    }

    public void removeByValue(T element) throws ArrayListException {
        for (int i = 0; i < size; i++){
            if (data[i].equals(element)){
                removeByIndex(i);
                return;
            }
        }
    }

    public void removeAllOccurrences(T element) throws ArrayListException {
        for (int i = 0; i < size;){
            if (data[i].equals(element)){
                removeByIndex(i);
            }else{
                i++;
            }
        }
    }

    public int indexOf(T element){
        for (int i = 0; i < size; i++){
            if (data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T element){
        for (int i = size-1; i >= 0; i--){
            if (data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public Object[] toArray(){
        return Arrays.copyOf(data, size);
    }

    public void ensureCapacity(int newCapacity){
        if (newCapacity > data.length){
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public void trimToSize(){
        if (data.length > size){
            Object[] temp = new Object[size];
            System.arraycopy(data,0,temp,0,size);
            data = temp;
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOfRange(data,0,size));
    }
}
