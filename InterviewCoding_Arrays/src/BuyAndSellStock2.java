/* Time complexity = O(n)
 * Space Complexity = O(1)*/
public class BuyAndSellStock2 {
	
	static int maxProfit(int[] prices) {
		
		int valley = prices[0];
		int peak = prices[0];
		int maxProfit = 0;
		int i = 0;
		
		while(i < prices.length - 1) {
			while(i < prices.length - 1 && prices[i] >= prices[i+1])
				i++;
			valley = prices[i];
			while(i < prices.length - 1 && prices[i] <= prices[i+1])
				i++;
			peak = prices[i];
			maxProfit += peak - valley;
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println("Maximum profit earned is : " + maxProfit(prices));
	}

}
