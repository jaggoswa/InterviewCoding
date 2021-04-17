
/* Time Complexity = O(n), Each element can be visited atmost twice, once by the right pointer and
 * (atmost)once by the left pointer 
 * Space Complexity = O(1) */
public class MinimumSizeSubarraySum {
	
	static int minSizeSubarraySum(int[] arr, int target) {
		
		int left = 0;
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			
			while(sum >= target) {
				minLen = Math.min(minLen, i+1-left);
				sum -= arr[left++];
			}
		}
		
		return minLen;
	}

	public static void main(String[] args) {
		int[] arr = {2,3,1,2,4,3};
		int target = 7;
		
		System.out.println("The minimum size subarray is: " + minSizeSubarraySum(arr,target));

	}

}
