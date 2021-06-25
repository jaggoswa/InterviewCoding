import java.util.*;

public class SameDifferences {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		int count = 0;
		
		for(int i=0; i<a.length; i++) {
			int diff = a[i] - i;
			
			if(hm.containsKey(diff)) {
				int val = hm.get(diff);
				count += val;
				hm.put(diff, val+1);
			}else {
				hm.put(diff, 1);
			}
		}
		
		System.out.print(count);

	}

}
