/*
You are given an N by M matrix of 0s and 1s. Starting from 
the top left corner, how many ways are there to reach the 
bottom right corner?

You can only move right and down. 0 represents an empty 
space while 1 represents a wall you cannot walk through.

For example, given the following matrix:
[[0, 0, 1],
 [0, 0, 1],
 [1, 0, 0]]
Return 2, as there are only two ways to get to the bottom right:
Right, down, down, right
Down, right, down, right
The top left corner and bottom right corner will always be 0.

Time:   ?
Space:  ? 
*/

public class NumberOfWaysToBottomRight{
    public static void main(String []args){
        int[][] matrix = {{0,0,1},
                          {0,0,1},
                          {1,0,0}
                        };
        System.out.println(findWaysToBottomRight(matrix, 0, 0));
    }
    
    private static int findWaysToBottomRight(int[][] matrix, int rowIndex, int colIndex){
        //bounds and value check
        if(rowIndex < 0 || rowIndex >= matrix.length) return 0;
        if(colIndex < 0 || colIndex >= matrix[rowIndex].length) return 0;
        if(matrix[rowIndex][colIndex] == 1) return 0;
        
        //chech if were at the end
        if(rowIndex == matrix.length-1 && colIndex == matrix[rowIndex].length-1){
            return 1;
        }
        
        //add the ways
        int ways = findWaysToBottomRight(matrix, rowIndex, colIndex+1)+//right
               findWaysToBottomRight(matrix, rowIndex+1, colIndex);//down
        
        return ways;
    }
}
