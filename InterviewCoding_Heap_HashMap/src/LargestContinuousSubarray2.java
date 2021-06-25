import java.util.HashSet;
public class LargestContinuousSubarray2 {
	
	public static int LCS(int[] arr) {
		
		int maxLength = 0;
		
		for(int i=0; i<arr.length; i++) {
			int min = arr[i];
			int max = arr[i];
			HashSet<Integer> hs = new HashSet<>();
			hs.add(arr[i]);
			
			for(int j=i+1; j<arr.length; j++) {
				if(hs.contains(arr[j])) {
					break;
				}
				
				if(arr[j] < min)
					min = arr[j];
				
				if(arr[j] >  max)
					max = arr[j];
				
				hs.add(arr[j]);
				
				int length = j - i + 1;
				if(max - min + 1 == length) {
					if(length > maxLength) {
						maxLength = length;
					}
				}
			}
		}
		
		return maxLength;
	}

	public static void main(String[] args) {
		
		int[] arr = {10, 12, 12, 10, 10, 11, 10};
		System.out.print(LCS(arr));
	}

}
