import java.util.HashMap;
import java.util.Map;


/* Time Complexity = O(n)
 * Space Complexity = O(n)*/
public class APSequence {

	public static void main(String[] args) {
		
		int[] arr = {0, 12, 4, 8};
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		int firstTerm = Integer.MAX_VALUE;
		int secondTerm = Integer.MAX_VALUE;
		
		//If only one element in array
		if(arr.length == 1) {
			System.out.print(false);
			return;
		}
		
		for(int e : arr) {
			//Finding first and second term of sequence
			if(e < firstTerm) {
				secondTerm = firstTerm;
				firstTerm = e;
			}
			else if(e != firstTerm && e < secondTerm) {
				secondTerm = e;
			}
			
			//Adding elements and their frequencies to hash map
			hm.put(e, hm.getOrDefault(e, 0) + 1);
		}
		
		//If there are duplicates, they can be in AP only if all elements are same
		for(Map.Entry<Integer, Integer> e : hm.entrySet()) {
			int val = e.getValue();
			if(val > 1 && val != arr.length) {
				System.out.print(false);
				return;
			}else if(val == arr.length){
				System.out.print(true);
				return;
			}
		}
		
		int commonDiff = secondTerm - firstTerm;
		int nextTerm = secondTerm;
		int size = arr.length-1;
		
		for (var i = 0; i < size; i++) {
	        if (!hm.containsKey(nextTerm)) {
	        	System.out.print(false);
	            return;
	        }
	        nextTerm += commonDiff;
	    }
		
		System.out.print(true);

	}

}
