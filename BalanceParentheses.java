/*
You're given a string consisting solely of (, ), and *. 
* can represent either a (, ), or an empty string. 
Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.

*/

/*
  Time: O(n)
  Space: O(1)
*/

class BalanceParentheses {
  public static void main(String []args){
      String str = "(*(*(*(****)";
        
      System.out.println(isBalanced(str));
    }
    private static boolean isBalanced(String str1){
        int leftParen = 0;
        int star = 0;
        
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == '('){
                leftParen++;
            }
            else if( str1.charAt(i) == '*'){
              star++; 
            }
            else{
                leftParen--;
                
                if(leftParen < 0 ){
                    if(star > 0){
                      leftParen++;
                      star--;
                    }else{
                        return false;
                    }
                }
            }
        }
        
        return (leftParen <= star);
    }
}
