public class TournamentMethod {
	
	static class Pair{
		int min;
		int max;
	}
	
	static Pair findMinMax(int arr[], int low, int high) {
		Pair minmax = new Pair();
		Pair left = new Pair();
		Pair right = new Pair();
		
		if(low == high) {
			minmax.max = arr[low];
			minmax.min = arr[low];
			return minmax;
		}
		
//		if(high == low + 1) {
//			if(arr[low] > arr[high]) {
//				minmax.max = arr[low];
//				minmax.min = arr[high];
//			}
//			else {
//				minmax.max = arr[high];
//				minmax.min = arr[low];
//			}
//			return minmax;
//		}
		
		int mid = (low + high)/2;
		left = findMinMax(arr,low,mid);
		right = findMinMax(arr,mid+1,high);
		
		if(left.min < right.min)
			minmax.min = left.min;
		else
			minmax.min = right.min;
		
		if(left.max > right.max)
			minmax.max = left.max;
		else
			minmax.max = right.max;
		
		return minmax;
	}

	public static void main(String[] args) {
		
		int[] arr = {6,3,7,2,4,5};
		Pair minmax = findMinMax(arr,0,arr.length-1);
		
		System.out.println("The minimum element is: " + minmax.min);
		System.out.println("The maximum element is: " + minmax.max);
	}

}
