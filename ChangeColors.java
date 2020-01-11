/*
Given a 2-D matrix representing an image, a location of a 
pixel in the screen and a color C, replace the color of 
the given pixel and all adjacent same colored pixels with C.

For example, given the following matrix, and location 
pixel of (2, 2), and 'G' for green:

B B W
W W W
W W W
B B B
Becomes

B B G
G G G
G G G
B B B
*/

/*
  Time:   O(row * col)
  Space:  O(row * col)
*/

public class ChangeColors{
    
    public static void main(String []args){
        String[][] colorImage = { { "B", "B", "W"},
                       { "W", "W", "W"},
                       { "W", "W", "W"},
                       { "B", "B", "B"}};
                       
        printMatrix(colorImage);
  
        changeColor(colorImage, 2, 2, colorImage[2][2], "G");
        
        printMatrix(colorImage);
    }
    
    private static void changeColor(String[][] colorImage, int row, int col, String oldColor, String newColor){
        //index out of bounds check of rows
        if(row < 0 || row >= colorImage.length){
            return;
        }
        //index out of bounds check of col
        if(col < 0 || col >= colorImage[row].length){
            return;
        }
        //return if the I have already changed the color
        if(colorImage[row][col].equals(newColor)){
            return;
        }
        // return if its a different color then we care about
        if(!colorImage[row][col].equals(newColor) && !colorImage[row][col].equals(oldColor) ){
            return;
        }
        //change the current color to the new if it 
        //matches the one we care and DFS the rest on the matrix
        if(colorImage[row][col].equals(oldColor)){
            colorImage[row][col] = newColor;
            changeColor(colorImage, row-1, col, oldColor, newColor);
            changeColor(colorImage, row, col+1, oldColor, newColor);
            changeColor(colorImage, row+1, col, oldColor, newColor);
            changeColor(colorImage, row, col-1, oldColor, newColor);
        }
    }
    
    private static void printMatrix(String[][] colorImage){
        System.out.println();
        for(int i = 0; i < colorImage.length; i++){
            for(int j = 0; j < colorImage[i].length; j++){
                System.out.print(colorImage[i][j]+ " ");
            }
            System.out.println();
        }
    }
    
    
}
