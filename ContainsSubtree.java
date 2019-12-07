/*
* Given two non-empty binary trees s and t, check whether 
* tree t has exactly the same structure and node values 
* with a subtree of s. A subtree of s is a tree consists 
* of a node in s and all of this node's descendants. 
* The tree s could also be considered as a subtree of itself.
*/

/*
* Time and space complexity
time:   O(n)
space:  O(1)
*/

public class ContainsSubtree{
   
    public static void main(String []args){
        Node tree = makeTree();
        Node subTree = makeSubTree();
       
        System.out.println(containsSubTree(tree, subTree, false));
    }
   
    private static boolean containsSubTree(Node tree, Node subTree, boolean checkCurrentSubTree){
       
        //if both the main tree and subtree return true if null
        if(tree == null && subTree == null){
            return true;
        }
        //if one tree is null over the other then return false
        if(tree == null || subTree == null){
            return false;
        }
       
        //if the root node of the subtree matches a node in the main tree then check that part of the tree
        //to see if the structure is the same between the trees
        if(tree.data == subTree.data) {
            return(containsSubTree(tree.left, subTree.left, true) && containsSubTree(tree.right, subTree.right, true));
        }else{
            if(checkCurrentSubTree){
                return false;
            }
        }
       
        // check the main tree until we find the root of the subtree
        return (containsSubTree(tree.left, subTree, false) || containsSubTree(tree.right, subTree, false));
       
    }
   
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int val){
            data = val;
        }
    }
    private static Node makeTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
    private static Node makeSubTree(){
        //Node root = null;
        Node root = new Node(3);
        root.left = new Node(6);
        root.right = new Node(7);
        return root;
    }
   
}
