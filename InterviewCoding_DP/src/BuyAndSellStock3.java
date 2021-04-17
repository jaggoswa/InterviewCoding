
public class BuyAndSellStock3 {
	
	static int maxProfit(int[] prices) {
		
		int length = prices.length;
		if(length == 0)
			return 0;
		
		//Max profit till now if sold today
		int min_buy_price = prices[0];
		int max_profit_here_left = 0;
		int[] dp_leftProfit = new int[length];
		
		for(int i=1; i<length; i++) {
			
			min_buy_price = Math.min(min_buy_price, prices[i]);
			max_profit_here_left = prices[i] - min_buy_price;
			dp_leftProfit[i] = Math.max(max_profit_here_left, dp_leftProfit[i-1]);
		}
		
		//Max profit till now if sold today
		int max_sell_price = prices[length-1];
		int max_profit_here_right = 0;
		int[] dp_rightProfit = new int[length];
		
		for(int i=length-2; i>=0; i--) {
			
			max_sell_price = Math.max(max_sell_price, prices[i]);
			max_profit_here_right =  max_sell_price - prices[i];
			dp_rightProfit[i] = Math.max(max_profit_here_right, dp_rightProfit[i+1]);
		}
		
		//Total profit
		int maxProfit = 0;
		for(int i=0; i<length; i++)
			maxProfit = Math.max(maxProfit, dp_leftProfit[i]+dp_rightProfit[i]);
		
		return maxProfit;
		
	}

	public static void main(String[] args) {
		
		int[] prices = {3,3,5,0,0,3,1,4};
		
		System.out.println("Maximum profit obtained: " + maxProfit(prices));
		

	}

}
