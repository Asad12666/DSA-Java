package LinkedList;

public class TestDoubly {
    static void main(String[] args){
        DoublyLinkedList<Integer> list = new DoublyLinkedList();

        list.addAll(1,2,3,4,5,4,4,4,5,6,7,8,9,10);


        list.removeAt(2);
        System.out.println(list);
        System.out.println(list.indexOf(4));
        list.removeAll(4);
        System.out.println(list);
    }
}
