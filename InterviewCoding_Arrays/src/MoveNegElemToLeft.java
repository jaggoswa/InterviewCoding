/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class MoveNegElemToLeft {
	
	static void rearrange(int[] arr) {
		int i=0, j=0;
		
		while(j <arr.length) {
			if(arr[j] < 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
			j++;
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
