package DSLabProject;


public class CustomLinkedList<T> {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node{
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
        }

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public void add(T data){
        Node node = new Node(data);
        if (tail == null && head == null){
            tail = head = node;
            size++;
            return;
        }

        addLast(data);
    }

    @SafeVarargs
    public final void add(T... args){
        for (T arg : args){
            add(arg);
        }
    }

    public void addFirst(T data){
        Node node = new Node(data);

        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T data){
        Node node = new Node(data);

        if (tail == null){
            head = tail = null;
        }else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void add(int index,T data){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size){
            addLast(data);
            return;
        }

        Node temp = getNode(index-1);

        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public Node getHead(){
        return head;
    }

    public T getFirst(){
        if (isEmpty()){
            throw new IllegalArgumentException("List is Empty.");
        }
        return head.data;
    }

    public T getLast(){
        if (isEmpty()){
            throw new IllegalArgumentException("List is Empty.");
        }
        return tail.data;
    }

    public T get(int index){
        Node temp = getNode(index);
        return temp.data;
    }

    public Node getNode(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public T removeFirst(){
        if (tail == null){
            throw new IllegalArgumentException("List is Empty.");
        }

        T removed = head.data;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return removed;
    }

    public T removeLast(){
        if (size == 0){
            throw new IllegalArgumentException("List is Empty.");
        }

        if (size == 1){
            T removed = head.data;
            head = tail = null;
            size--;
            return removed;
        }

        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }

        T removed = tail.data;
        tail = temp;
        temp.next = null;
        size--;
        return removed;
    }

    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bound.");
        }

        if (index == 0) return removeFirst();

        if (index == size-1) return removeLast();

        Node temp = getNode(index-1);

        T removed = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return removed;
    }

    public void set(int index,T data){
        Node temp = getNode(index);
        temp.data = data;
    }

    public int indexOf(T data){
        Node temp = head;
        for (int i = 0; i < size; i++){

            if (data == null){
                if (temp.data == null) return i;
            }else {
                if (temp.data.equals(data)) return i;
            }

            temp = temp.next;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        Node temp = head;
        int index = -1;

        for (int i = 0; i < size; i++){
            if (data == null){
                if (temp.data == null){
                    index = i;
                }
            }else{
                if (temp.data.equals(data)){
                    index = i;
                }
            }
            temp = temp.next;
        }

        return index;
    }

    public boolean contains(T data){
        Node temp = head;
        for (int i = 0; i < size; i++){
            if (data == null){
                if (temp.data == null) return true;
            }else {
                if (temp.data.equals(data)) return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void clear(){
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        Node temp = head;
        while (temp != null){
            string.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        string.append("null");
        return string.toString();
    }
}
