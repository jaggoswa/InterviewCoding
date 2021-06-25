import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
		
		pq.add(5);
		pq.add(4);
		pq.add(9);
		pq.add(2);
		pq.add(3);
		
		System.out.print(pq);

	}

}
