import java.util.Arrays;

/* Time Complexity = O(n^2)
 * Space Complexity = O(n)*/
public class LongestBitonicSubsequence {
	
	public static int LBS(int[] arr) {
		int n = arr.length;
		int[] lis = new int[n];
		int[] lds = new int[n];
		
		Arrays.fill(lis, 1);
		Arrays.fill(lds, 1);
		
		for(int i=1; i<lis.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j])
					lis[i] = Math.max(lis[i], 1 + lis[j]);
			}
		}
		
		for(int i=lds.length-2; i>=0; i--) {
			for(int j=lds.length-1; j>i; j--) {
				if(arr[i] > arr[j])
					lds[i] = Math.max(lds[i], 1 + lds[j]);
			}
		}
		
		int lbs_length = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			lbs_length = Math.max(lbs_length, lis[i] + lds[i] - 1);
		}
		
		return lbs_length;
		
	}

	public static void main(String[] args) {
		int[] arr = {80, 60, 30, 40, 20, 10};
		
		System.out.print(LBS(arr));
	}

}
