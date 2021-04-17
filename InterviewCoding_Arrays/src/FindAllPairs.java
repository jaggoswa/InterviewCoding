import java.util.HashMap;

public class FindAllPairs {
	
	static void findAllPairs(int[] arr, int sum) {
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			int diff = sum - arr[i];
			
			if(hm.containsKey(diff)) {
				int count = hm.get(diff);
				
				for(int j=0; j<count; j++) {
					System.out.println(arr[i] + " " + diff);
				}
			}
			
			if(hm.containsKey(arr[i]))
				hm.put(arr[i], hm.get(arr[i]) + 1);
			else
				hm.put(arr[i], 1);
		}
		
	}

	public static void main(String[] args) {
		int[] arr = {1, 5, 7, -1, 5};
		int sum = 6;
		
		findAllPairs(arr,sum);

	}

}
