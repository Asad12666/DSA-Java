package DataStructures;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static void main() {
        ArrayList<Integer> list = new ArrayList<>(List.of(45,67,89,20));
        MyStackLL<Integer> stack = new MyStackLL<>();
        stack.pushAll(1,2,3,4,5,6,7,8,9,10);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println("Size of Stack: " + stack.size());
        stack.pushAll(list);
        System.out.println(stack);
        System.out.println(stack.pop());
    }
}
