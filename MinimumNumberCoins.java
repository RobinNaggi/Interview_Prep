/*
Find the minimum number of coins required to make n cents.

You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.

For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.
*/

/*
  time: O(n)
  space: O(1)
*/

public class MinimumNumberCoins{

    public static void main(String []args){
        int n = 16;
        
        System.out.println(findMinCoinsToTarget(n));
    }
    
    private static int findMinCoinsToTarget(int cents){
        if(cents <= 0) return 0;
        
        int numberOfCoins = 0;
        //US coins
        int[] coins = {25, 10, 5, 1};
        int currentCoinIndex = 0;
        
        //find the max cents that can be taken away to the get the min number of coins needed
        while(cents > 0){
            if(coins[currentCoinIndex] > cents){
                currentCoinIndex++;
            }else{
                cents = cents - coins[currentCoinIndex];
                numberOfCoins++;
            }
        }
        
        return numberOfCoins;
    }
    
}
