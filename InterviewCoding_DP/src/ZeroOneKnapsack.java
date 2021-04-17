import java.util.Scanner;

public class ZeroOneKnapsack {
	
	static int knapsack(int[] weight, int[] profit, int capacity) {
		int rows = weight.length + 1;
		int cols = capacity + 1;
		
		int[][] dp = new int[rows][cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(weight[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j],profit[i-1] + dp[i-1][j - weight[i-1]]);
			}
		}
		
		return dp[rows-1][cols-1];
	}

	public static void main(String[] args) {
		int[] profit = {60, 100, 120};
		int[] weight = {10, 20, 30};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the knapsack capacity: "); //Provide capacity as 220
		int capacity = sc.nextInt();
		
		System.out.println("Maximum profit obtained is: " + knapsack(weight,profit,capacity));

	}

}
