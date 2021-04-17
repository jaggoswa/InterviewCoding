import java.util.Arrays;

/* Time Complexity = O(n Log n) as we apply sorting before subarray search 
 * Space Complexity = O(1) */
public class ChocolateDistribution {
	
	static int minDifference(int[] arr, int m, int n) {
		
		if(m==0 || n==0)
			return 0;
		
		if(n < m)
			return -1;
		
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		
		for(int i=0; i+m-1<n; i++) {
			int diff = arr[i+m-1] - arr[i];
			
			if(diff < minDiff)
				minDiff = diff;
		}
		
		return minDiff;
	}

	public static void main(String[] args) {
		int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
		int m = 7; //No. of children
		int n = arr.length;
		
		System.out.print("Minimum difference is: " + minDifference(arr,m,n));

	}

}
