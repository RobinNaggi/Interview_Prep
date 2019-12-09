/*
Given a sorted list of integers, square the elements and give the output in sorted order.

For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
*/

/*
* Time and space complexity
    N: total number of values in the array
  time:   O(N + Nlog(N)) -> O(Nlog(N))
  space:  O(1)
*/

import java.util.Arrays;
public class SortedSquareArray{

    public static void main(String []args){
        
        int[] input = makeInputArray();
        System.out.println("Before: "+Arrays.toString(input));
        System.out.println("After: "+Arrays.toString(getSortedSquaredArray(input)));
        
    }
    
    private static int[] getSortedSquaredArray(int[] input){
        //return null if the input array is null
        if(input == null ) return null;
        
        //return the same array if the length is 0
        if(input.length == 0) return input;
        
        //square the input arrays value in the array
        //time:   O(N)
        for(int i = 0; i < input.length; i++){
            input[i] = (int)Math.pow(input[i],2);
        }
        //sort the input array 
        //time:   O(Nlog(N))
        Arrays.sort(input);
        
        return input;
        
    }
    
    private static int[] makeInputArray(){
        int[] input = {-9, -2, 0, 2, 3};
        
        return input;
    }
}
