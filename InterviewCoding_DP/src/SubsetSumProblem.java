import java.util.Scanner;



public class SubsetSumProblem {
	
	static boolean subsetSum(int[] arr, int sum) {
		int rows = arr.length + 1;
		int cols = sum + 1; 
		boolean[][] dp = new boolean[rows][cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(j == 0)
					dp[i][j] = true;
				else if(i == 0)
					dp[i][j] = false;
				else if(j < arr[i - 1])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]]; //Replace OR with '+' for finding number of subset sums
			}
		}
		
		return dp[rows-1][cols-1];
	}

	public static void main(String[] args) {
		int[] arr = {2,4,2,3};
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the sum: ");
		int sum = sc.nextInt();
		boolean present = subsetSum(arr,sum);
		
		if(present)
			System.out.println("Subset with given sum is possible");
		else
			System.out.println("Subset with given sum is not possible");

	}

}
