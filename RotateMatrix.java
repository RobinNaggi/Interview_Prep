/*
Given an N by N matrix, rotate it by 90 degrees clockwise.

For example, given the following matrix:
[[1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]]
you should return:
[[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]
Follow-up: What if you couldn't use any extra space?

Time:   O()
Space:  O(1)
*/

public class RotateMatrix{
    
    public static void main(String []args){
        int[][] matrix = getMatrix();
        System.out.println("Before:");
        printMatrix(matrix);
        
        System.out.println("Clockwise:");
        
        printMatrix(rotate90Clockwise(matrix));
        matrix = getMatrix();
        
        System.out.println("Anti-Clockwise:");
        printMatrix(rotate90AntiClockwise(matrix));
    }
    
     private static int[][] rotate90Clockwise(int[][] matrix){
        int length = matrix.length;
        
        for(int i = 0; i < length/2; i++){
            for(int j = i; j < length - i - 1; j++){
                int temp = matrix[i][j]; 
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
                
            }
        }
        return matrix;
        
     }
    
    private static int[][] rotate90AntiClockwise(int[][] matrix){
        int length = matrix.length;
        
        for(int i = 0; i < length/2; i++){
            for(int j = i; j < length - i - 1; j++){
                int temp = matrix[i][j]; 
                matrix[i][j] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = temp;
            }
        }
        return matrix;
        
    }
    
    private static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
    
    private static int[][] getMatrix(){
        int[][] matrix = {  {1,2,3},
                            {4,5,6},
                            {7,8,9}
                        };
        
        return matrix;
    }
}
