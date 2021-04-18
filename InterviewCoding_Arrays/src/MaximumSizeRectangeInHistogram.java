import java.util.LinkedList;
import java.util.Stack;

public class MaximumSizeRectangeInHistogram {
	
	/* Time Complexity = O(n^2)
	 * Space Complexity = O(1)*/
//	static int maxSizeRectangle(int[] arr) {
//		
//		int maxArea = 0;
//		
//		for(int l=0; l<arr.length; l++) {
//			int minHeight = arr[l];
//			
//			for(int r=l; r<arr.length; r++) {
//				minHeight = Math.min(minHeight,arr[r]);
//				int width = r-l+1;
//				int area = minHeight * width;
//				maxArea = Math.max(maxArea, area); 
//			}
//		}
//		
//		return maxArea;
//		
//	}
	
	/* Time Complexity = O(n)
	 * Space Complexity = O(n)*/
	static int maxSizeRectangle(int[] arr) {
		
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		
		int[] left = new int[arr.length];
		stack.push(0);
		left[0] = -1;
		
		for(int i=1; i<arr.length; i++) {
			
			while(stack.size() > 0 && arr[i] < arr[stack.peek()]) {
				stack.pop();
			}
			
			if(stack.size() == 0) {
				left[i] = -1;
			}
			else {
				left[i] = stack.peek();
			}
			
			stack.push(i);
			
		}
		
		stack = new Stack<>();
		int[] right = new int[arr.length];
		stack.push(arr.length-1);
		right[arr.length - 1] = arr.length;
		
		for(int i=arr.length-2; i>=0; i--) {
			while(stack.size() > 0 && arr[i] < arr[stack.peek()]) {
				stack.pop();
			}
			
			if(stack.size() == 0) {
				right[i] = arr.length;
			}
			else {
				right[i] = stack.peek();
			}
			
			stack.push(i);
			
		}
		
		for(int i=0;i<arr.length; i++) {
			int width = right[i] - left[i] - 1;
			int area = arr[i] * width;
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
		
	}

	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		
		System.out.println("Maximum size rectange: " + maxSizeRectangle(heights));

	}

}
