import java.util.HashMap;
public class CountPairsDivisibleByK {
	
	public static int countPairs(int[] arr, int k) {
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		int ans = 0;
		
		for(int n : arr) {
			int rem = n % k;
			
			if(rem == 0 && hm.containsKey(rem)) {
				ans += hm.get(rem);
			}
			
			if(hm.containsKey(k-rem)) {
				ans += hm.get(k-rem);
			}
			
			hm.put(rem, hm.getOrDefault(rem, 0) + 1);
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {5, 9, 36, 74, 52, 31, 42};
		int k = 3;
		
		System.out.print(countPairs(arr,k));

	}

}
