/*
Given a list of numbers L, implement a method sum(i, j) 
which returns the sum from the sublist L[i:j] (including i, excluding j).

For example, given L = [1, 2, 3, 4, 5], sum(1, 3) 
should return sum([2, 3]), which is 5.

You can assume that you can do some pre-processing. 
sum() should be optimized over the pre-processing step.

Time:   O(n) but the sum method is O(1)
Space:  O(n)  
*/

import java.util.Map;
import java.util.HashMap;

public class OptimizedSum{

    public static void main(String []args){
        int[] L = getList();
        
        GettingSums findSum = new GettingSums(L);
        System.out.println(findSum.sum(1,3));
    }
    
    private static int[] getList(){
        int[] list = {1,2,3,4,5};
        return list;
    }
    static class GettingSums{
        int[] L;
        Map<Integer, Integer> sumsList = new HashMap<Integer, Integer>();
    
        GettingSums(int[] list){
            L = list;
            int sum = 0;
        
            for(int i = 0; i < list.length; i++){
                sum+=list[i];
                sumsList.put(i, sum);
            }
        
        }
        public int sum(int x, int y){
            return sumsList.get(y-1) - sumsList.get(x-1);
        }
    }
}
