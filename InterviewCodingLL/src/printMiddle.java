
public class printMiddle {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void printMiddle(Node head) {
		Node slowPtr = head, fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		System.out.print("The middle element of the linked list is: ");
		System.out.print(slowPtr.data);
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {
		
		printMiddle llist = new printMiddle();
		
		llist.insert(7);
		llist.insert(6);
		llist.insert(5);
		llist.insert(4);
		llist.insert(3);
		llist.insert(2);
		llist.insert(1);
		
		llist.printMiddle(llist.head);
		
	}

}
