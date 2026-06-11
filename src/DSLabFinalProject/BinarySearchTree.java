package DSLabFinalProject;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int size = 0;

    private class Node {
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
        }
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, T data) {
        if (root == null) {
            size++;
            return new Node(data);
        }
        int cmp = data.compareTo(root.data);
        if (cmp < 0) {
            root.left = insertRec(root.left, data);
        } else if (cmp > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public boolean contains(T data) {
        return containsRec(root, data);
    }

    private boolean containsRec(Node root, T data) {
        if (root == null) return false;
        int cmp = data.compareTo(root.data);
        if (cmp == 0) return true;
        return cmp < 0 ? containsRec(root.left, data) : containsRec(root.right, data);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    public void clear() {
        root = null;
        size = 0;
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
}