/*
Given a binary tree, find a minimum path sum from root to a leaf.

For example, the minimum path in this tree is [10, 5, 2, 1, -1], which has sum 15.

  10
 /  \
5    5
 \     \
   2    1
       /
     -1
*/


import java.util.List;
import java.util.ArrayList;
public class AllRootToLeafPathsMinimumSum{
    
    //current min sum of the tree
    static int minSum = Integer.MAX_VALUE;
    public static void main(String []args){
       Node tree = makeTree();
       
       findAllRootToLeafNodePaths(tree, new ArrayList<Integer>());
       System.out.println(minSum);
    }
    
    
    private static void findAllRootToLeafNodePaths(Node node, List<Integer> currentPath){
       //if the node is null we'll return because we dont care about it 
       if(node == null) return;
       
       //since the node is not null we'll add it to a new list so 
       //we can save it in the stack space of all paths that we try.
       List<Integer> pathSoFar = new ArrayList<Integer>(currentPath);
       pathSoFar.add(node.data);
        
       //check if the current node is a leaf node and if it is then we find the sum
       if(node.left == null && node.right == null){
           int sum = getSum(pathSoFar);
           minSum = Math.min(minSum, sum);
           return;
       }
        
       //to reduce time and space complexity
       //the code could be run without this check but it will be slower and take more space.
       if(node.left != null){
           findAllRootToLeafNodePaths(node.left, pathSoFar);
       }
       if(node.right != null){
           findAllRootToLeafNodePaths(node.right, pathSoFar);
       }
        
    }
    
    // returns the sum of the array
    private static int getSum(List<Integer> pathSoFar){
        int sum = 0;
        for(int num : pathSoFar){
            sum+=num;
        }
        return sum;
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
        root.right = new Node(5);
        root.left.right = new Node(2);
        root.right.right = new Node(1);
        root.right.right.left = new Node(-1);
        return root;
    }
   
}
