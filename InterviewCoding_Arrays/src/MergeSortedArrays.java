
public class MergeSortedArrays {
	
	/* Time Complexity = O(mn)
	 * Space Complexity = O(1)*/
	static void merge(int[] arr1, int[] arr2) {
		
		int m = arr1.length;
		int n = arr2.length;
		
		for(int i=0; i<m; i++) {
			if(arr1[i] > arr2[0]) {
				int temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;
				
				int first = arr2[0];
				int k;
				
				for(k=1; k<n && arr2[k] < first; k++) {
					arr2[k-1] = arr2[k];
				}
				
				arr2[k-1] = first;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1 = {1, 5, 9, 10, 15, 20};
		int[] arr2 = {2, 5, 8, 13};
		
		merge(arr1,arr2);
		
		for(int elem : arr1) {
			System.out.print(elem + " ");
		}
		
		System.out.println();
		
		for(int elem : arr2) {
			System.out.print(elem + " ");
		}

	}

}
