
public class QuickSort {
	
	static void sort(int[] arr, int left, int right) {
		if(left < right) {
			int pivot = partition(arr,left,right);
			sort(arr,left,pivot-1);
			sort(arr,pivot+1,right);
		}
	}
	
	static int partition(int[] arr, int left, int right) {
		int i = left-1;
		int j = left;
		int pivot = arr[right];
		
		while(j<right) {
			if(arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			j++;
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = temp;
		
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,8,3,5};
		sort(arr,0,arr.length-1);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
