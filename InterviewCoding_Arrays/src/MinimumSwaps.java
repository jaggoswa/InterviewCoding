/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class MinimumSwaps {
	
	static int minimumSwaps(int[] arr, int k) {
		int count = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] <= k)
				count++;
		}
		
		int i = 0, j = 0;
		int bad = 0;
		int minSwap = Integer.MAX_VALUE;
		
		while(j < arr.length) {
			if(arr[j] > k)
				bad++;
			
			if(j-i+1 < count)
				j++;
			else if(j-i+1 == count) {
				minSwap = Math.min(minSwap, bad);
			
				if(arr[i] > k)
					bad--;
				
				i++;
				j++;
			}
		}
		
		return minSwap;
	}

	public static void main(String[] args) {
		int[] arr = {2, 7, 9, 5, 8, 7, 4};
		
		System.out.println("Minimum swaps required: " + minimumSwaps(arr,5));

	}

}
