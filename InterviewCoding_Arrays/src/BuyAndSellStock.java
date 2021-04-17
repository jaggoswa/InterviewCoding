/* Time Complexity = O(n), as only single pass needed
 * Space Complexity = O(1), as only two variables are used*/
public class BuyAndSellStock {
	
	static int maxProfit(int[] arr) {
		
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < minPrice)
				minPrice = arr[i];
			else if(arr[i] - minPrice > maxProfit)
				maxProfit = arr[i] - minPrice;
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		int arr[] = {7,1,5,3,6,4};
		
		System.out.println("The maximum profit from selling stocks is: " + maxProfit(arr));

	}

}
