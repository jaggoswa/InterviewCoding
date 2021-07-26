
public class CountingSort {
	
	public static void countingSort(int[] arr) {
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int a : arr) {
			min = Math.min(min, a);
			max = Math.max(max, a);
		}
		
		int range = max - min + 1;
		int[] freqArr = new int[range];
		
		for(int i=0; i<arr.length; i++) {
			int idx = arr[i] - min;
			freqArr[idx]++;
		}
		
		for(int i=1; i<freqArr.length; i++) {
			freqArr[i] = freqArr[i] + freqArr[i-1];
		}
		
		int[] ans = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--) {
			int val = arr[i];
			int pos = freqArr[val - min];
			ans[pos-1] = arr[i];
			freqArr[val - min]--;
		}
		
		for(int i=0; i<ans.length; i++) {
			arr[i] = ans[i];
		}
	}

	public static void main(String[] args) {
		
		int arr[] = {4, 7, 3, 5, 12, 8};
		
		System.out.println("Original array:");
		for(int e : arr) {
			System.out.print(e + " ");
		}
		
		countingSort(arr);
		
		System.out.println();
		System.out.println("Sorted array:");
		for(int e : arr) {
			System.out.print(e + " ");
		}

	}

}
