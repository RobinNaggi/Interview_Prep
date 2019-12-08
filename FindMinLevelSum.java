/*
Given a binary tree, return the level of the tree with minimum sum.
For example, given the tree:

L1:                10
L1:           /          \
L2:          10          40
L1:        /    \      /    \
L3:       1      1     1     1
L3:      / \    / \   / \   / \
L4:     1   2  3   4 5   6 7   8
       
Return 3.
*/

/*
* Time and space complexity
    h: height of the tree 
    t: total number of node in the tree
  time:   O(t)

  space:  O( log(t) )
    find all node in tree: 
          2^h - 1 = t
          h * log(2) - log(1) = log(t)
          h * log(2) - 0 = log(t)
          h * log(2) = log(t)
          h = log(t)/log(2)
          h = ( 1/log(2) ) * log(t) : log(2) is a constant 
          h = log(t)
*/


import java.util.Map;
import java.util.HashMap;
public class FindMinLevelSum{

    
    public static void main(String []args){
        
        Node root = makeTree();
        
        System.out.println(findMinimumSumLevelInGivenTree(root));
    }
    
    private static int findMinimumSumLevelInGivenTree(Node tree){
        Map<Integer, Integer> sumAtEachLevelMap = new HashMap<Integer, Integer>();
        
        findLevelSums(tree, sumAtEachLevelMap, 1);
        
        return getMinimumSumLevel(sumAtEachLevelMap);
    }
   
    private static void findLevelSums(Node node, Map<Integer, Integer> sumAtEachLevelMap, int treeLevel){
           //we don't care about nulls
           if(node == null){
            return;
        }
        //get the sum at current "treeLevel"
        Integer currentLevelSum = sumAtEachLevelMap.get(treeLevel);
        //if the current level was not found then we put the current value of the node in it
        //if it was was found then we add the current node value to the total sum currently present
        sumAtEachLevelMap.put(treeLevel, (currentLevelSum == null) ? node.data : currentLevelSum+node.data);
        
        //goes through all nodes in the tree
        findLevelSums(node.left, sumAtEachLevelMap, treeLevel+1);
        findLevelSums(node.right, sumAtEachLevelMap, treeLevel+1);
        
    }
       
    private static int getMinimumSumLevel(Map<Integer, Integer> sumAtEachLevelMap){
        int minLevel = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        for (Map.Entry<Integer,Integer> levelSums : sumAtEachLevelMap.entrySet()){  
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 

            if(levelSums.getValue() < minSum){
                minSum = levelSums.getValue();
                minLevel = levelSums.getKey();
            }
        }
        
        return minLevel;
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
        root.left = new Node(10);
        root.right = new Node(40);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(1);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.right = new Node(6);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(8);
        
        return root;
    }
}
