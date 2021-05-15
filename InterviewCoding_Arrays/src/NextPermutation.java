/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class NextPermutation {
	
	static int[] nextPermutation(int[] nums) {
		
		int i = nums.length-2;
		
		//Find the strictly decreasing section
		while(i >= 0 && nums[i+1] <= nums[i]) {
			i--;
		}
		
		if(i >= 0) {
			int j = nums.length - 1;
			
			//Find smallest element which is greater or equal than element in ith position
			while(j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			
			swap(nums,i,j);
		}
		
		int j = nums.length-1;
		i++;
		
		//Reverse the strictly decreasing section
		while(i < j) {
			swap(nums,i,j);
			i++;
			j--;
		}
		
		return nums;
		
	}
	
	static void swap(int arr[],int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,5};
		
		nextPermutation(nums);
		
		for(int e : nums) {
			System.out.print(e + " ");
		}

	}

}
