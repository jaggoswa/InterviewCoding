/* Time Complexity = O(n), 
 * Space Complexity = O(1)*/
public class MaximumSumSubarray {
	
	//Kadane's Algorithm
	static int findMaximumSubarray(int[] arr) {
		
		int max_ending_here = arr[0];
		int max_so_far = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			
			max_ending_here = Math.max(max_ending_here + arr[i], arr[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		
		return max_so_far;
		
	}

	public static void main(String[] args) {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println("The maximum contiguous subarray sum is : " + findMaximumSubarray(arr));

	}

}
