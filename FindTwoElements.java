/*
Given an array of integers in which two elements appear 
exactly once and all other elements appear exactly twice, 
find the two elements that appear only once.

For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], 
return 4 and 8. The order does not matter.
*/

/*
  1.
      Time: O(n) 
      Space: O(n)
  2. 
      Time: O(nlog(n)) 
      Space: O(1)
*/

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class HelloWorld{

    public static void main(String []args){
        int[] list = getList();
        
        int[] singleElements = findSingleElements(list);
        System.out.println("Time: O(n) Space: O(n) RESULT: " + Arrays.toString(singleElements));
        
        singleElements = getSingleElements(list);
        System.out.println("Time: O(nlog(n)) Space: O(1) RESULT: " + Arrays.toString(singleElements));
        
    }
    
    private static int[] findSingleElements(int[] list){
        int[] result = new int[2];
        int resultListInputIndex = 0;
        
        if(list.length <= 1) return result;
        
        Map<Integer, Integer> elementFrequencyMap = new HashMap<Integer, Integer>();
        
        for(int element : list){
            Integer frequency = elementFrequencyMap.get(element);
            elementFrequencyMap.put(element, (frequency == null) ? 1 : frequency+1);
        }
        
        for(Map.Entry<Integer, Integer> entry  : elementFrequencyMap.entrySet()){
            if(entry.getValue() == 1){
                result[resultListInputIndex] = entry.getKey();
                resultListInputIndex++;
            }
            if(resultListInputIndex == 2) break;
        }
        
        return result;
    }
    
    private static int[] getSingleElements(int[] list){
        int[] result = new int[2];
        int resultListInputIndex = 0;
        
        if(list.length <= 1) return result;
      
        Arrays.sort(list);

        int listIndex = 0;
        while(listIndex < list.length){
            
            int currentElement = list[listIndex];
            int currentElementCount = 0;
            int currentElementIndex = listIndex;
            
            while(currentElementIndex < list.length && currentElement == list[currentElementIndex]){
                currentElementCount++;
                currentElementIndex++;
            }
            
            if(currentElementCount == 1){
                result[resultListInputIndex] = currentElement;
                resultListInputIndex++;
            }
            
            if(resultListInputIndex == 2) break;
            
            listIndex = currentElementIndex;
        }
        
        return result;
    }
    
    private static int[] getList(){
        int[] list = {2,4,6,8,10,2,6,10};
        return list;
    }
}
