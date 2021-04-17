
public class DeleteLastOccurrenceLL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void deleteLastOccurrence(int k) {
		Node temp = head, lastOccur = null;
		
		while(temp != null) {
			if(temp.data == k)
				lastOccur = temp;
			temp = temp.next;
		}
		
		if(lastOccur != null && lastOccur.next == null) {
			temp = head;
			while(temp.next != lastOccur) {
				temp = temp.next;
			}
			
			temp.next = null;
		}
		
		if(lastOccur != null && lastOccur.next != null) {
			lastOccur.data = temp.data;
			lastOccur.next = lastOccur.next.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
