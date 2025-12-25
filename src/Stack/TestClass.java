package Stack;

public class TestClass {
    static void main() throws Exception{
        CustomDynamicStack<Integer> stack = new CustomDynamicStack<>();
        CustomDynamicStack<String> stack1 = new CustomDynamicStack<>();
        CustomDynamicStack<Double> stack2 = new CustomDynamicStack<>();

        stack.pushMultiple(1,2,3,4,5,6,7,8,9,10);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println("Popped Element: "+ stack.pop());
        System.out.println("Popped Element: "+ stack.pop());
        System.out.println(stack+"\n\n");

        stack1.pushMultiple("Asad", "Majid", "Subaiyal", "Abdullah", "Uzair", "Hammad", "Zubair");
        System.out.println(stack1);
        System.out.println(stack1.peek());
        System.out.println("Popped Element: "+ stack1.pop());
        System.out.println("Popped Element: "+ stack1.pop());
        System.out.println(stack1+"\n\n");

        stack2.pushMultiple(56.3, 67.9, 12.8, 78.4, 45.3, 12.9);
        System.out.println(stack2);
        System.out.println(stack2.peek());
        System.out.println("Popped Element: "+ stack2.pop());
        System.out.println("Popped Element: "+ stack2.pop());
        System.out.println(stack2+"\n\n");
    }
}
