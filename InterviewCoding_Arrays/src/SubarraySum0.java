import java.util.HashSet;

/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class SubarraySum0 {

	static boolean subarraySum(int[] arr) {
		int sum = 0;
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			
			if(arr[i] == 0 || sum == 0 || hs.contains(sum))
				return true;
			
			hs.add(sum);
		}
		
		return false;
	}
	public static void main(String[] args) {
		int[] arr = {-3, 2, 3, 1, 6};
		
		if(subarraySum(arr))
			System.out.print("The array has subarray of sum 0");
		else
			System.out.print("The array doesn't have a subarray of sum 0");

	}

}
