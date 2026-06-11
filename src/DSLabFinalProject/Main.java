package DSLabFinalProject;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. Polymorphic Collection & List Verification ---");
        Collection<Integer> arrayListCol = new CustomArrayList<>();
        arrayListCol.add(10);
        arrayListCol.add(20);
        
        List<Integer> linkedListAsList = new CustomLinkedList<>();
        linkedListAsList.add(100);
        linkedListAsList.add(200);
        linkedListAsList.add(1, 150);

        System.out.println("ArrayList (via Collection ref): " + arrayListCol);
        System.out.println("LinkedList (via List ref): " + linkedListAsList);

        System.out.println("\n--- 2. Stack Verification ---");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack State: " + stack);
        System.out.println("Popped item: " + stack.pop());

        System.out.println("\n--- 3. Queue & Deque Verification ---");
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(10);
        System.out.println("ArrayQueue: " + arrayQueue);

        Deque<String> linkedDeque = new LinkedDeque<>();
        linkedDeque.addFirst("Middle");
        linkedDeque.addFirst("Front");
        linkedDeque.addLast("Back");
        System.out.println("LinkedDeque state: " + linkedDeque);

        System.out.println("\n--- 4. Non-Linear Structure (BST) Verification ---");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        
        System.out.print("Inorder Traversal: ");
        bst.inorder();

        System.out.println("Clearing and rebuilding tree...");
        bst.clear(); // Works perfectly now!
        bst.insert(40);
        bst.insert(20);
        
        System.out.print("New Inorder Traversal: ");
        bst.inorder();
    }
}