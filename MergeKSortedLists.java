/*
MergeKSortedLists 
[ {3,5,7},
  {0,6},
  {0,6,8}
]
return
[0, 0, 3, 5, 6, 6, 7, 8]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MergeKSortedLists{

    public static void main(String []args){
        int[][] lists = {{3,5,7},
                         {0,6},
                         {0,6,8}
                                };
        
        int[] indexInLists = new int[lists.length];
        
        Map<Integer, Integer>  outOfBoundsCheck = new HashMap<Integer, Integer>();
        outOfBoundsCheck.put(1, 0);
        
        List<Integer> orderedList = new ArrayList<Integer>();
        
        while(outOfBoundsCheck.get(1) < indexInLists.length){
            outOfBoundsCheck.put(1, 0);
            
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            
            for(int i = 0; i < indexInLists.length; i++){
                
                if(lists[i].length == indexInLists[i]){
                    outOfBoundsCheck.put(1, outOfBoundsCheck.get(1)+1);
                }else{
                    int currentValue = lists[i][indexInLists[i]];
                    
                    if(currentValue < minValue){
                        minValue = currentValue;
                        minIndex = i;
                    }
                }
            }
            
            if(outOfBoundsCheck.get(1) < indexInLists.length){
                indexInLists[minIndex]++;
                orderedList.add(minValue);
            }
            
        }
        System.out.println(orderedList.toString());
    }
}
