/*
Given a node in a binary search tree, return the next bigger element, also known as the inorder successor.

For example, the inorder successor of 22 is 30.

   10
  /  \
 5    30
     /  \
   22    35
*/

/*
  time: O(n)
  space: O(n)
*/


public class InorderSuccessor{

    public static void main(String []args){
        //holds the result -1 for not found, -25 false target
        int[] result = {-25, -1};
        Node root = makeTree();
        
        findInorderSuccessor(root, result, 30);
        
        
        System.out.println(result[1]);
    }
    
    private static void findInorderSuccessor(Node node, int[] result, int target){
        
        if(node == null) {
            return;
        }
        //sets the redult to the parent of the left node
        if(node.left != null && node.left.data == target ){
            result[0] = target;
            result[1] = node.data;
            return;
        }
        //sets the result to the target because we dont want to return an 
        //element thats smaller then the target
        if(node.right != null && node.right.data == target ){
            result[0] = target;
            result[1] = target;
            return;
        }
        
        findInorderSuccessor(node.left, result, target);
        findInorderSuccessor(node.right, result, target);
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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(30);
        root.right.left = new Node(22);
        root.right.right = new Node(35);
        return root;
    }
}
