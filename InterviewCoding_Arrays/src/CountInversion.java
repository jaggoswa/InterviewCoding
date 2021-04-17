import java.util.Arrays;

/* Time Complexity = O(nlogn), for the mergesort
 * Space Complexity = O(n)
 */
public class CountInversion {
	
	static int merge(int[] arr, int[] aux, int low, int mid, int high) {
		int k = low, i = low, j = mid+1;
		int count = 0;
		
		while(i <= mid && j <= high) {
			if(arr[i] <= arr[j])
				aux[k++] = arr[i++];
			else {
				aux[k++] = arr[j++];
				count += mid-i +1;
			}
		}
			
			while(i <= mid) {
				aux[k++] = arr[i++];
			}
			
			for(i=low; i<high; i++) {
				arr[i] = aux[i];
			}
		
		return count;
	}
	
	static int mergeSort(int[] arr, int[] aux, int low, int high) {
		if(low == high)
			return 0;
		
		int mid = (low + high)/2;
		int count = 0;
		
		count += mergeSort(arr,aux,low,mid);
		count += mergeSort(arr,aux,mid+1,high);
		count += merge(arr,aux,low,mid,high);
		
		return count;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 9, 6, 4, 5};
		int[] aux = Arrays.copyOf(arr, arr.length);
		
		int inversionCount = mergeSort(arr,aux,0,arr.length-1);
		
		System.out.print("The inversion count of the array is: " + inversionCount);

	}

}
