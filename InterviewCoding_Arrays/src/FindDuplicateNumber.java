/*Problem statement : Given an array of integers nums 
 * containing n + 1 integers where each integer is in 
 * the range [1, n] inclusive.*/

/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class FindDuplicateNumber {
	
	static int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		
		//Find intersection point
		do {
			
			slow = nums[slow];
			fast = nums[nums[fast]];
			
		}while(slow != fast);
		
		slow = nums[0];
		
		//Find entrance of the cycle
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return fast;
	}

	public static void main(String[] args) {
		int[] arr = {3,1,3,4,2};
		
		System.out.print("The duplicate element is : " + findDuplicate(arr));

	}

}
