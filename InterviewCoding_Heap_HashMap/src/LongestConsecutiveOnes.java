
public class LongestConsecutiveOnes {
	
	public static int LCO(int[] arr) {
		
		int count = 0;
		int maxCount = 0;
		
		for(int i : arr) {
			if(i == 1) {
				count++;
			}else {
				count = 0;
				maxCount = Math.max(maxCount, count);
			}
		}
		
		if(arr[arr.length - 1] == 1) {
			maxCount = Math.max(maxCount, count);
		}
		
		return maxCount;
	}

	public static void main(String[] args) {
		int[] arr = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1};
		System.out.println(LCO(arr));
	}

}
