import java.util.HashMap;
import java.util.Map;

public class APSequence {

	public static void main(String[] args) {
		
		int[] arr = {0, 12, 4, 4, 8};
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		int firstTerm = Integer.MAX_VALUE;
		int secondTerm = Integer.MAX_VALUE;
		
		//If only one element in array
		if(arr.length == 1) {
			System.out.print(false);
			return;
		}
		
		//Finding first and second term of sequence
		for(int e : arr) {
			if(e < firstTerm) {
				secondTerm = firstTerm;
				firstTerm = e;
			}
			else if(e != firstTerm && e < secondTerm) {
				secondTerm = e;
			}
		}
		
		//Adding elements and their frequencies to hash map
		for(int e : arr) {
			if(hm.containsKey(e)) {
				int val = hm.get(e);
				hm.put(e, val+1);
			}
			else {
				hm.put(e, 1);
			}
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
		int nextTerm = firstTerm + commonDiff;
		int size = arr.length-1;
		
		while(size > 0) {
			if(!hm.containsKey(nextTerm)) {
				System.out.print(false);
				return;
			}
			nextTerm += commonDiff;
			size--;
		}
		
		System.out.print(true);

	}

}
