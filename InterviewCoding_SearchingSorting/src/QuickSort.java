
public class QuickSort {
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int[] arr, int l, int r) {
		
		int i = l;
		int j = l-1;
		int pivot = arr[r];
		
		while(i <= r) {
			if(arr[i] < pivot) {
				j++;
				swap(arr, i, j);
			}
			i++;
		}
		
		swap(arr, j+1, r);
		
		return j+1;
	}
	
	public static void quickSort(int[] arr, int l, int r) {
		if(l < r) {
			int p = partition(arr, l, r);
			quickSort(arr, l, p-1);
			quickSort(arr, p+1, r);
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = {4, 7, 3, 5, 12, 8};
		
		System.out.println("Original array:");
		for(int e : arr) {
			System.out.print(e + " ");
		}
		
		quickSort(arr, 0, arr.length-1);
		
		System.out.println();
		System.out.println("Sorted array:");
		for(int e : arr) {
			System.out.print(e + " ");
		}

	}

}
