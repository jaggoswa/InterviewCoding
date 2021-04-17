
public class MaxMinInArray {
	
	static class Pair{
		int min;
		int max;
	}
	
	static Pair findMinMax(int[] arr) {
		
		Pair minmax = new Pair();
		int n = arr.length;
		
		minmax.max = arr[0];
		minmax.min = arr[0];
		
		for(int i=1; i<n; i++) {
			if(arr[i] > minmax.max) 
				minmax.max = arr[i];
			else if(arr[i] < minmax.min)
				minmax.min = arr[i];
		}
		
		return minmax;
	}

	public static void main(String[] args) {
		
		int[] arr = {6,3,7,2,4,5};
		Pair minmax = findMinMax(arr);
		
		System.out.println("The minimum element is: " + minmax.min);
		System.out.println("The maximum element is: " + minmax.max);
	}

}
