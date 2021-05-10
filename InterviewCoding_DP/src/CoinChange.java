import java.util.Arrays;

/* Problem Statement: Given an array of integers that represent coins called coins 
 * and an integer amount, return the minimum amount of coins it requires 
 * to make complete change for amount.*/


public class CoinChange {
	
	static int minCoins(int[] coins, int amount) {
		
		int[] dp = new int[amount + 1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for(int i=1; i<=amount; i++) {
			for(int j=0; j<coins.length; j++) {
				if(i >= coins[j])
					dp[i] = Math.min(dp[i],1 + dp[i-coins[j]]);
			}
		}
		
		return dp[amount] > amount ? -1 : dp[amount];
		
	}

	public static void main(String[] args) {
		int[] coins = {1, 3, 5, 6, 9};
		int amount = 90;
		
		System.out.print("Minimum coins required: " + minCoins(coins,amount));

	}

}
