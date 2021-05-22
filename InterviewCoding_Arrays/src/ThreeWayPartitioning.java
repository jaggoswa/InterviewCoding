
/* Time Complexity = O(n)
 * SpaceComplexity = O(1)
 */
public class ThreeWayPartitioning {
	
	static void partition(int[] arr, int lowVal, int highVal) {
		int start = 0, end = arr.length - 1;
		int i = 0;
		
		while(i <= end) {
			if(arr[i] < lowVal) {
				swap(arr,i,start);
				start++;
				i++;
			}else if(arr[i] > highVal) {
				swap(arr,i,end);
				end--;
			}else {
				i++;
			}
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
		partition(arr,10,20);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
