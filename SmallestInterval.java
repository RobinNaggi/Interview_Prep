/*
* Given a set of closed intervals, find the smallest set of 
* numbers that covers all the intervals. If there are multiple 
* smallest sets, return any of them.

* For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9], 
* one set of numbers that covers all these intervals is {3, 6}.
*/

/*
* Time and space complexity
  Time:  O(N)
  Space: O(1)
*/


import java.util.Set;
import java.util.HashSet;

public class SmallestInterval {

    public static void main(String []args){
        
        Set<int[]> closedIntervalsSetList = makeIntervals();
        
        int[] result = findSmallestClosedInterval(closedIntervalsSetList);
        System.out.println("["+ result[0] + ", "+ result[1] + "]");
    }
    
    private static int[] findSmallestClosedInterval(Set<int[]> closedIntervalsSetList){
        
        //smallest set of numbers that covers all the intervals.
        int minEndPoint = Integer.MAX_VALUE;
        int maxStartingPoint = Integer.MIN_VALUE;
        
        //we look over each interval and check if the: 
        //starting interval is the maximum ending interval it can be,
        //ending interval is the minimum starting interval it can be.
        for(int[] closedIntervals : closedIntervalsSetList){
            int currentStart = closedIntervals[0];
            int currentEnd = closedIntervals[1];
            
            // update the values as need while going through the interval set
            minEndPoint = Math.min(minEndPoint, currentEnd);
            maxStartingPoint = Math.max(maxStartingPoint, currentStart);
        }
        
        //return the smallest interval
        int[] result = {minEndPoint, maxStartingPoint};
        return result;
        
    }
    
    // [[0, 3], [2, 6], [3, 4], [6, 9]]
    private static Set<int[]> makeIntervals(){
        
        Set<int[]> closedIntervalsList = new HashSet<int[]>();
        
        int[] interval1 = {0, 3};
        closedIntervalsList.add(interval1);
        
        int[] interval2 = {2, 6};
        closedIntervalsList.add(interval2);
        
        int[] interval3 = {3, 4};
        closedIntervalsList.add(interval3);
        
        int[] interval4 = {6, 9};
        closedIntervalsList.add(interval4);
        
        return closedIntervalsList;
    }
}
