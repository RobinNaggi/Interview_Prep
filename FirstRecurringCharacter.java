/*
Given a string, return the first recurring character in it, 
or null if there is no recurring character.

For example, given the string "acbbac", return "b". 
Given the string "abcdef", return null.

Time:   O(n)
Space:  O(n)


*/

import java.util.Set;
import java.util.HashSet;

public class FirstRecurringCharacter{
    
    public static void main(String []args){
        String str = "acbbac"; // return b;
        String str2 = "abcdef"; // return null;
        
        System.out.println(findFirstRecurringCharacter(str));    
        
        System.out.println(findFirstRecurringCharacter(str2));    
        
    }
    
    private static Character findFirstRecurringCharacter(String str){
        //if the string length is 0 or 1 there will not be recurring characters
        // so we return a null
        if(str.length() <= 1) return null;
        
        //contains the all the seen characters in the string
        Set<Character> seenCharacter = new HashSet<Character>();
        
        //checks to see if we have seen the current character or not
        for(int i = 0; i < str.length(); i++){
            if(seenCharacter.contains(str.charAt(i))){
                return str.charAt(i);
            }else{
                seenCharacter.add(str.charAt(i));
            }
        }
        
        return null;
    }
    
    private static Character findFirstRecurringCharacterPart2(String str){
        if(str.length() <= 1) return null;
        
        int[] seenCharacter = new int[26];
        
        for(int i = 0; i < str.length(); i++){
            if(seenCharacter[str.charAt(i) - 'a'] != 0){
                return str.charAt(i);
            }else{
                seenCharacter[str.charAt(i) - 'a']++;
            }
        }
        return null;
    }
}
