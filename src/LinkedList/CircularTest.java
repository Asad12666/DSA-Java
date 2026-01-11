package LinkedList;

public class CircularTest {
    static void main() throws Exception {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addAll(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
    }
}
