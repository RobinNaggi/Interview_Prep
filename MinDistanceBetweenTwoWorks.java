/*
Find an efficient algorithm to find the smallest 
distance (measured in number of words) between any 
two given words in a string.

For example, given words "hello", and "world" and a 
text content of "dog cat hello cat dog dog hello cat world", 
return 1 because there's only one word "cat" in between the two words.

Time:   O(n)
Space:  O(1)
*/

import java.util.Arrays;
import java.util.Stack;

public class MinDistanceBetweenTwoWorks{
    public static void main(String []args){
        
        String[] twoWords = {"hello","world"};
        String sentence = "dog cat+ hello! cat dog, dog hello cat' world";
        
        //remove all other characters from the string besides whitespace 
        sentence = sentence.replaceAll("[^a-zA-Z0-9\\s+]", "");
        
        // split the string in to an array by the spaces
        String[] words = sentence.split(" ");
        
        System.out.println(findMinDistanceBetweenTwoWords(twoWords, words));
    }
    
    private static int findMinDistanceBetweenTwoWords(String[] twoWords, String[] words){
        //return -1 if there is on data to evaluate 
        if(words.length == 0 || twoWords.length == 0) return -1;
        
        //set distance to max so i can get the min
        int distance = Integer.MAX_VALUE;
        
        //stack to hold the index of all the first word instances 
        Stack<Integer> firstWordIndexStack = new Stack<Integer>();
        
        for(int i = 0; i < words.length; i++){
            
            //if the current word is equal to first words 
            //add the index to the stack
            //if there is something already on in then pop
            //it and add the new one
            if(words[i].equals(twoWords[0])){
                if(!firstWordIndexStack.isEmpty()){
                    firstWordIndexStack.pop();
                    firstWordIndexStack.push(i);
                }else{
                    firstWordIndexStack.push(i);
                }
            }
            //if the current word is equal to the second word and the stack is not empty
            //meaning we have see at least one instance of the first word
            else if(words[i].equals(twoWords[1]) && !firstWordIndexStack.isEmpty() ){
                //calculate the min distance
                int wordIndex = firstWordIndexStack.pop();
                distance = Math.min(distance, i - wordIndex - 1);
            }
        }
        
        return (distance == Integer.MAX_VALUE)? -1 : distance;
    }
}
