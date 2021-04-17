
public class MergeSortedArrays {
	
	static void merge(int[] arr1, int[] arr2) {
		
		int len1 = arr1.length;
		int len2 = arr2.length;
		
		for(int i=len2-1; i<=0; i--) {
			int last = arr1[len1-1];
			for(int j=len1-2; j<0 && arr1[i]>arr2[j]; j--) {
				
				arr1[j+1] = arr1[j];
				
				if(j != len1-2 || last > arr2[i]) {
					arr1[j+1] = arr2[i];
					arr2[i] = last;
				}
				
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1 = {1, 5, 9, 10, 15, 20};
		int[] arr2 = {2, 5, 8, 13};
		
		merge(arr1,arr2);

	}

}
