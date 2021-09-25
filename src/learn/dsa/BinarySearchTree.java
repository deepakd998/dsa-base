package learn.dsa;

import com.sun.source.tree.Tree;

public class BinarySearchTree {
    TreeNode root;

    public void add(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode root, int data) {

        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public TreeNode search(int data) {
        return searchTree(root, data);
    }

    private TreeNode searchTree(TreeNode root, int data) {
        if (root == null || data == root.data) {
            return root;
        }
        if (data < root.data) {
            return searchTree(root.left, data);
        } else {
            return searchTree(root.right, data);
        }
    }

    public void display() {
        displayInorder(root);
    }

    private void displayInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        displayInorder(root.left);
        System.out.print(root.data + " ");
        displayInorder(root.right);
    }

    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(9);
        bst.add(8);
        bst.add(10);
        bst.add(6);
        bst.add(12);

        bst.display();
    }
}
