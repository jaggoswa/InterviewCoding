
public class MergeSort {
	
	public static void merge(int[] arr, int[] aux, int l, int m, int r) {
		
		int i = l, j = m + 1;
		int k = l;
		
		while(i <= m && j <= r) {
			if(arr[i] <= arr[j]) {
				aux[k++] = arr[i++];
			}else {
				aux[k++] = arr[j++];
			}
		}
		
		while(i <= m) {
			aux[k++] = arr[i++];
		}
		
		// No need to copy the second half (since the remaining items
	    // are already in their correct position in the auxiliary array)
		
		for(i=l; i<=r; i++) {
			arr[i] = aux[i];
		}
	}
	
	public static void mergeSort(int[] arr, int[] aux, int l, int r) {
		if(l < r) {
			int mid = l + (r-l)/2;
			mergeSort(arr, aux, l, mid);
			mergeSort(arr, aux, mid+1, r);
			merge(arr, aux, l, mid, r);
		}
	}

	public static void main(String[] args) {
		int arr[] = {4, 7, 3, 5, 12, 8};
		
		System.out.println("Original array:");
		for(int e : arr) {
			System.out.print(e + " ");
		}
		
		int[] aux = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			aux[i] = arr[i];
		}
		mergeSort(arr, aux, 0, arr.length-1);
		
		System.out.println();
		System.out.println("Sorted array:");
		for(int e : arr) {
			System.out.print(e + " ");
		}

	}

}
