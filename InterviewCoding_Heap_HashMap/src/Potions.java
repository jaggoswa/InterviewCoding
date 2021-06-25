import java.util.PriorityQueue;
import java.util.Scanner;

public class Potions {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int count = 0;
		long pos = 0, neg = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] >= 0) {
				pos += arr[i];
				count++;
			}else {
				if(pos >= neg + Math.abs(arr[i])) {
					pq.add(arr[i]);
					neg += Math.abs(arr[i]);
				}else {
					if(pq.size() == 0) {
						continue;
					}
					long temp = Math.abs(pq.peek());
					if(Math.abs(arr[i]) < temp) {
						pq.remove();
						pq.add(arr[i]);
						neg = neg - temp + Math.abs(arr[i]);
					}
				}
			}
		}
		
		System.out.println(count + pq.size());

	}

}
