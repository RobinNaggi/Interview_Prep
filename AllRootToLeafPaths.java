/*
Given a binary tree, return all paths from the root to leaves.

For example, given the tree:

   1
  / \
 2   3
    / \
   4   5
Return [[1, 2], [1, 3, 4], [1, 3, 5]].
*/

/*
* Time and space complexity
  time:   O(n)
  space:  O()
*/


import java.util.List;
import java.util.ArrayList;
public class AllRootToLeafPaths{
   
    public static void main(String []args){
       Node tree = makeTree();
       
       //this hold all the paths in the tree from the root to all leaf nodes
       List<List<Integer>> allRootToLeafNodePathsList = new ArrayList<List<Integer>>();
       
       findAllRootToLeafNodePaths(tree, allRootToLeafNodePathsList, new ArrayList<Integer>());
       System.out.println(allRootToLeafNodePathsList);
    }
    
    private static void findAllRootToLeafNodePaths(Node node, List<List<Integer>> allRootToLeafNodePathsList, List<Integer> currentPath){
       //if the node is null we'll return because we dont care about it 
       if(node == null) return;
       
       //since the node is not null we'll add it to a new list so 
       //we can space it in the stack space of all paths that we try.
       List<Integer> pathSoFar = new ArrayList<Integer>(currentPath);
       pathSoFar.add(node.data);
        
       //check if the current node is a leaf node and if it then we add it to all paths list 
       if(node.left == null && node.right == null){
           allRootToLeafNodePathsList.add(pathSoFar);
           return;
       }
        
       //to reduce time and space complexity
       //the code could be run without this check but it will be slower and take more space.
       if(node.left != null){
           findAllRootToLeafNodePaths(node.left, allRootToLeafNodePathsList, pathSoFar);
       }
       if(node.right != null){
           findAllRootToLeafNodePaths(node.right, allRootToLeafNodePathsList, pathSoFar);
       }
        
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
   
}
