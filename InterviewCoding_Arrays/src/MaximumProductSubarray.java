/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class MaximumProductSubarray {
	
	static int maximumProduct(int[] arr) {
		
		if(arr.length == 0)
			return 0;
		
		int max_ending_here = arr[0], min_ending_here = arr[0];
		int max_so_far = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			
			int temp_max = Math.max(Math.max(max_ending_here * arr[i], min_ending_here * arr[i]),arr[i]);
			min_ending_here = Math.min(Math.min(max_ending_here * arr[i], min_ending_here * arr[i]),arr[i]);
			max_ending_here = temp_max;
			max_so_far  = Math.max(max_so_far, max_ending_here);
		}
		
		return max_so_far;
	}

	public static void main(String[] args) {
		
		int[] arr = {2,3,-2,4};
		
		System.out.println("The maximum product subarray is : " + maximumProduct(arr));
	}

}
