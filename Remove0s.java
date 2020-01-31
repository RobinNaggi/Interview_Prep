/*
Given a binary tree where all nodes are either 0 or 1, 
prune the tree so that subtrees containing all 0s are removed.

For example, given the following tree:

   0
  / \
 1   0
    / \
   1   0
  / \
 0   0
should be pruned to:

   0
  / \
 1   0
    /
   1
We do not remove the tree at the root or its left 
child because it still has a 1 as a descendant.

Time:   O(n)
Space:  O(log(n))
*/

public class Remove0s{
    
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int val){
            data = val;
        }
    }
    public static void main(String []args){
        Node root = makeTree();
        
        //1 0 0 1 0 0 0 
        printTree(root);
        System.out.println();
        
        prune(root);
        
        //1 0 1 0
        printTree(root);
    }
    
    private static boolean prune(Node root){
        if(root == null) return false;
        
        boolean leftDelete = prune(root.left);
        boolean rightDelete = prune(root.right);
        
        if(leftDelete)  root.left = null;
        if(rightDelete) root.right = null;
        
        if(leftDelete && rightDelete || !leftDelete && !rightDelete){
            if(root.data == 0) return true;
        }
        
        return false;
        
    }
    
    private static void printTree(Node root){
        if(root == null) return;
        
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }
    
    private static Node makeTree(){
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(1);
        root.right.right = new Node(0);
        root.right.left.left = new Node(0);
        root.right.left.right = new Node(0);
        return root;
    }
}
