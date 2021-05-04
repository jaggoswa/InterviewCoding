/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class CyclicRotationByK {
	
	static void reverse(int[] arr, int start, int end) {
		
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
	}
	
	static void rotate(int[] arr, int k) {
		
		k %= arr.length;
		int n = arr.length;
		
		reverse(arr,0,n-1);
		reverse(arr,0,k-1);
		reverse(arr,k, n-1);
		
	}

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		
		rotate(nums,k);
		
		for(int elem : nums) {
			System.out.print(elem + " ");
		}

	}

}
