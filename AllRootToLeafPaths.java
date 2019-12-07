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
  time:   O()
  space:  O()
*/


import java.util.*;
public class AllRootToLeafPaths{
   
    public static void main(String []args){
        Node tree = makeTree();
    
        List<List<Integer>> allRootToLeafNodePathsList = new ArrayList<List<Integer>>();
        findAllRootToLeafNodePaths(tree, allRootToLeafNodePathsList, new ArrayList<Integer>());
        System.out.println(allRootToLeafNodePathsList);
    }
    
    private static void findAllRootToLeafNodePaths(Node node, List<List<Integer>> allRootToLeafNodePathsList, List<Integer> currentPath){
        if(node == null) return;
        
        List<Integer> pathSoFar = new ArrayList<Integer>(currentPath);
        pathSoFar.add(node.data);
        
        if(node.left == null && node.right == null){
            allRootToLeafNodePathsList.add(pathSoFar);
            return;
        }
        
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
