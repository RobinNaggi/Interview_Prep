/*
You are given an array of nonnegative integers. 
Let's say you start at the beginning of the array 
and are trying to advance to the end. You can advance 
at most, the number of steps that you're currently on. 
Determine whether you can get to the end of the array.

For example, given the array [1, 3, 1, 2, 0, 1], 
we can go from indices 0 -> 1 -> 3 -> 5, so return true.

Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.
*/

public class PathToEndOfArray{

    public static void main(String []args){
        int[] a = {1, 3, 1, 2, 0, 1};
        //int[] a = {1, 2, 1, 0, 0};
        
        System.out.println(pathToEnd(0, a));
    }
    
    private static boolean pathToEnd(int currentIndex, int[] a){
        if(currentIndex > a.length-1) return false;
        if(currentIndex + a[currentIndex] == a.length-1) return true;
        if(a[currentIndex] == 0) return false;
        
        int start = currentIndex+1;
        int end = start + a[start];
        
        while(start <= end ){
            if(pathToEnd(start, a)){
                return true;            
            }
            start++;
        }
        
        return false;
    }
}
