/* Time complexity = O(n^2)
 * Space Complexity = O(1)*/
public class InsertionSort {

	public static void sort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && key < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
		
	}
	public static void main(String[] args) {
		int arr[] = {4, 7, 3, 5, 12, 8};
		
		System.out.println("Original array:");
		for(int e : arr) {
			System.out.print(e + " ");
		}
		
		sort(arr);
		
		System.out.println();
		System.out.println("Sorted array:");
		for(int e : arr) {
			System.out.print(e + " ");
		}

	}

}
