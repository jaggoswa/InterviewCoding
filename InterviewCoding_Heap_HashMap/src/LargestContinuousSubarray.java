
public class LargestContinuousSubarray {
	
	public static int LCS(int[] arr) {
		
		int maxLength = 0;
		
		for(int i=0; i<arr.length; i++) {
			int min = arr[i];
			int max = arr[i];
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < min)
					min = arr[j];
				else if(arr[j] > max)
					max = arr[j];
				
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
		
		int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
		System.out.print(LCS(arr));
	}

}
