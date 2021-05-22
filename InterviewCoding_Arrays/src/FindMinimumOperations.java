/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class FindMinimumOperations {
	
	static int findMinOps(int[] arr) {
		
		int minOps = 0;
		int i=0, j=arr.length-1;
		
		while(i <= j) {
			
			if(arr[i] == arr[j]) {
				i++;
				j--;
			}
			else if(arr[i] > arr[j]) {
				j--;
				arr[j] += arr[j+1];
				minOps++;
			}
			else{
				i++;
				arr[i] += arr[i-1];
				minOps++;
			}
		}
		
		return minOps;
	}

	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 9, 1};
		System.out.println("Minimum operations required: " + findMinOps(arr));

	}

}
