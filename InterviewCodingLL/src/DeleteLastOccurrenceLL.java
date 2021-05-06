/* Time Complexity = O(n)
 * Space Complexity = O(1)
 */
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
			lastOccur.data = lastOccur.next.data;
			temp = lastOccur.next;
			lastOccur.next = lastOccur.next.next;
		}
	}
	
	void insert(int data) {
		
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		
	}
	
	
	void printList() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		
		System.out.print("NULL");
	}

	public static void main(String[] args) {
		
		DeleteLastOccurrenceLL llist = new DeleteLastOccurrenceLL();
		
		llist.insert(4);
		llist.insert(4);
		llist.insert(5);
		llist.insert(4);
		llist.insert(3);
		llist.insert(2);
		llist.insert(1);
		
		System.out.println("Original list");
		llist.printList();
		
		llist.deleteLastOccurrence(4);
		System.out.println();
		System.out.println("The list after deletion");
		llist.printList();
		
	}

}
