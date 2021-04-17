import java.util.HashMap;
import java.util.Map.Entry;

/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */
public class ElemAppearingMoreThanNbyK {
	
	static void moreThanNbyK(int[] arr, int k) {
		int n = arr.length;
		int ratio = n/k;
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		for(int i : arr) {
			if(hm.containsKey(i)) {
				int val = hm.get(i);
				hm.put(i, val+1);
			}
			else {
				hm.put(i, 1);
			}
		}
		
		for(Entry<Integer,Integer> e : hm.entrySet()) {
			if(e.getValue() > ratio)
				System.out.print(e.getKey() + " ");
		}	 
	}

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 5, 4, 2, 2, 3, 1, 1, 1};
		int k = 4;
		
		moreThanNbyK(arr,k);

	}

}
