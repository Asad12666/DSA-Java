package DataStructures;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {
    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();
        ArrayList<Integer> list = new ArrayList<>(List.of(56,87,23));
        stack.pushAll(1,2,3,4,5,6,7,8,9,10);
        stack.pushAll(list);

//        System.out.println(Arrays.toString(stack.popMultiple(3)));
//        System.out.println(stack.size());
//        stack.swapTop();
        System.out.println(stack);
    }
}
