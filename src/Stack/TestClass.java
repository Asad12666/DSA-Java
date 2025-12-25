package Stack;

public class TestClass {
    static void main() throws Exception{
        CustomDynamicStack<Integer> stack = new CustomDynamicStack<>();
        CustomDynamicStack<String> stack1 = new CustomDynamicStack<>();
        CustomDynamicStack<Double> stack2 = new CustomDynamicStack<>();

        stack.pushMultiple(1,2,3,4,5,6,7,8,9,10);
        stack1.pushMultiple("Asad", "Majid", "Subaiyal", "Umaima", "Sadia", "Minal", "Zubair");
    }
}
