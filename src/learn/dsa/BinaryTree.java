package learn.dsa;

import java.util.*;

public class BinaryTree {
    private TreeNode root;

    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

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
    public void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
    public void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public void iterativePreOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

    public void iterativeInOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp=root;
        while(!stack.isEmpty() || temp!=null){

            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else {
                temp=stack.pop();
                System.out.print(temp.data+" ");
               temp=temp.right;
            }
        }
    }


    public void iterativeLevelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }
    public List<List<Integer>> zigZagOrder(TreeNode root){
        List<List<Integer>> res= new ArrayList<>();
        zigZagOrderTraversal(root,res,0);
        for(int i=1;i< res.size();i++){
            if(i%2==0){
               List<Integer> lvlData= res.get(i);
               Collections.reverse(lvlData);
                res.set(i,lvlData);
            }
        }
        return res;
    }

    private void zigZagOrderTraversal(TreeNode root, List<List<Integer>> res, int lvl) {
        if(root ==null){
            return;
        }

            try{
               List<Integer> lvlList= res.get(lvl);
               lvlList.add(root.data);
            }catch (IndexOutOfBoundsException e){
              List<Integer> list=new ArrayList<>();
              list.add(root.data);
              res.add(lvl,list);
            }

        zigZagOrderTraversal(root.left,res,lvl+1);
        zigZagOrderTraversal(root.right,res,lvl+1);
    }

    public int findMax(TreeNode root){
        if(root ==null){
            return Integer.MIN_VALUE;
        }
        int result=root.data;
        int left=findMax(root.left);
        int right=findMax(root.right);
        if(left>right){
            result=left;
        }
        if (right>left){
            result=right;
        }
        return result;
    }
    public void createBinaryTree(){
        TreeNode first= new TreeNode(1);
        TreeNode second= new TreeNode(2);
        TreeNode third= new TreeNode(3);
        TreeNode fourth= new TreeNode(4);
        TreeNode fifth= new TreeNode(5);
        TreeNode sixth= new TreeNode(6);
        TreeNode seventh= new TreeNode(7);
        root=first;
        root.right=third;
        root.left=second;
        second.right=fifth;
        second.left=fourth;
        third.right=seventh;
        third.left=sixth;
    }

    public static void main(String[] args) {
        BinaryTree btree=new BinaryTree();
        btree.createBinaryTree();
        System.out.print(btree.zigZagOrder(btree.root));

    }
    /*
     1
  2      3
4   5  6   7
     */
}
