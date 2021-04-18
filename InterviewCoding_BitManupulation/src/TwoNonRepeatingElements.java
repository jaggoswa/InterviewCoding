
/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class TwoNonRepeatingElements {
	
	static void findNonRepeatingElements(int[] arr) {
		
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum = sum^arr[i];
		}
		
		sum = sum & -sum;
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i=0; i<arr.length; i++) {
			
			if((sum & arr[i])> 0) {
				sum1 = sum1^arr[i];
			}
			else {
				sum2 = sum2^arr[i];
			}
			
		}
		
		System.out.println("Two non-repeating elements are: " + sum1 + "," + sum2);
		
	}

	public static void main(String[] args) {
		int[] arr = {2,2,4,3,3,5};
		findNonRepeatingElements(arr);

	}

}
