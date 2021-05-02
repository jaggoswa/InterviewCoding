/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class MoveNegElemToLeft {
	
	static void rearrange(int[] arr) {
		int j=0, temp;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < 0) {
				if(i != j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		rearrange(arr);
		
		for(int i : arr) {
			System.out.print(i + ",");
		}

	}

}
