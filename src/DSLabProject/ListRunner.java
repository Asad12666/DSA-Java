package DSLabProject;

import java.util.Scanner;

public class ListRunner {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Data Structures Lab Project ---");
            System.out.println("1. Singly Linked List Operations");
            System.out.println("2. Doubly Linked List Operations");
            System.out.println("3. Exit");
            System.out.print("Select List Type: ");
            int choice = sc.nextInt();

            if (choice == 1) singlyMenu();
            else if (choice == 2) doublyMenu();
            else if (choice == 3) break;
            else System.out.println("Invalid Choice!");
        }
    }

    private static void singlyMenu() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        boolean back = false;
        while (!back) {
            System.out.println("\n[Singly List] 1.Add 2.Add At Index 3.Remove 4.Display 5.Back");
            System.out.print("Select operation: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    list.add(sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter index and value: ");
                    list.add(sc.nextInt(), sc.nextInt());
                }
                case 3 -> {
                    System.out.print("Enter index to remove: ");
                    System.out.println("Removed: " + list.remove(sc.nextInt()));
                }
                case 4 -> System.out.println("List: " + list);
                case 5 -> back = true;
            }
        }
    }

    private static void doublyMenu() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        boolean back = false;
        while (!back) {
            System.out.println("\n[Doubly List] 1.Add 2.Remove 3.Display Forward 4.Display Reverse 5.Back");
            System.out.print("Select operation: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    list.add(sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter index: ");
                    list.removeAt(sc.nextInt());
                }
                case 3 -> System.out.println("Forward: " + list);
                case 4 -> System.out.println("Reverse: " + list.displayReverse());
                case 5 -> back = true;
            }
        }
    }
}