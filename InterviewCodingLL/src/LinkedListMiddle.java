public class LinkedListMiddle {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void printMiddle() {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		System.out.println("\nThe middle element is: "+slowPtr.data);
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	void printList() {
		Node ptr = head;
		
		System.out.println("The linked list is:");
		while(ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
	}

	public static void main(String[] args) {
		
		LinkedListMiddle llist = new LinkedListMiddle();
		
		for(int i=6; i>=1; i--) {
			llist.insert(i);
		}
		
		llist.printList();
		llist.printMiddle();
	}

}
