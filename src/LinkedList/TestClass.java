package LinkedList;


import java.nio.DoubleBuffer;

public class TestClass {
    static void main(String[] args){
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        CustomLinkedList<String> list1 = new CustomLinkedList<>();
        CustomLinkedList<DoubleBuffer> list2 = new CustomLinkedList<>();

        list.add(12,67,34,56,78,99,123,45,67,8,123,67,23);
        list.add(2,190);

        System.out.println(list);

        System.out.println(list.lastIndexOf(67));
        System.out.println(list.contains(67));

        System.out.println("Size: "+ list.size());

        System.out.println("First Node data: "+ list.getFirst());
        System.out.println("Last Node data: "+ list.getLast());
        list.removeFirst();
        System.out.println(list);
        list.clear();
        System.out.println(list);
        System.out.println("Size: "+ list.size());
    }
}