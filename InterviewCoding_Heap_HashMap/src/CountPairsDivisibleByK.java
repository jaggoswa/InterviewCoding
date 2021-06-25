import java.util.HashMap;
public class CountPairsDivisibleByK {
	
	public static int countPairs(int[] arr, int k) {
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		
		for(int e : arr) {
			int rem = e % k;
			
			if(rem == 0 && hm.containsKey(rem)) {
				int val = hm.get(rem);
				count += val;
			}
			
			if(hm.containsKey(k - rem)) {
				count += hm.get(k - rem);
			}
			
			if(hm.containsKey(rem)){
				int val = hm.get(rem);
				hm.put(rem, val+1);
			}else {
				hm.put(rem, 1);
			}
		}
		
		return count;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {5, 9, 36, 74, 52, 31, 42};
		int k = 3;
		
		System.out.print(countPairs(arr,k));

	}

}
