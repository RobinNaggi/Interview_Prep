/*
Given a list of words, find all pairs of unique indices 
such that the concatenation of the two words is a palindrome.

For example, given the list ["code", "edoc", "da", "d"], 
return [(0, 1), (1, 0), (2, 3)].

Time:   O(n^2)
Space:  O(n)
*/

import java.util.List;
import java.util.ArrayList;

public class UniqueIndicesPalindrome{
    static class Point{
        int x;
        int y;
        Point(int xx, int yy){
            x = xx;
            y = yy;
        }
    }
    
    public static void main(String []args){
        String[] words = {"code", "edoc", "da", "d"};
        
        List<Point> points = findUniquePairs(words);
        
        printPointsList(points);
    }
    
    private static List<Point> findUniquePairs(String[] words){
        List<Point> points = new ArrayList<Point>();
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i != j){
                    if(isPalindrome(words[i]+words[j])){
                        points.add(new Point(i, j));
                    }
                }
            }
        }
        return points;
    }
    
    private static boolean isPalindrome(String word){
        int start = 0;
        int end = word.length()-1;
        
        while(start < end){
            if(word.charAt(start) != word.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    private static void printPointsList(List<Point> points){
        for(Point currentPoint : points ){
           System.out.print("(" + currentPoint.x + ", " + currentPoint.y + ") " ); 
        }
    }
}

