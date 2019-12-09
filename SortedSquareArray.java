/*
Given a sorted list of integers, square the elements and give the output in sorted order.

For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
*/


import java.util.Arrays;
public class SortedSquareArray{

    public static void main(String []args){
        
        int[] input = makeInputArray();
        System.out.println("Before: "+Arrays.toString(input));
        System.out.println("After: "+Arrays.toString(getSortedSquaredArray(input)));
        
    }
    
    private static int[] getSortedSquaredArray(int[] input){
        if(input == null ) return null;
        if(input.length == 0) return input;
        
        for(int i = 0; i < input.length; i++){
            input[i] = (int)Math.pow(input[i],2);
        }
        
        Arrays.sort(input);
        
        return input;
        
    }
    
    private static int[] makeInputArray(){
        int[] input = {-9, -2, 0, 2, 3};
        
        return input;
    }
}