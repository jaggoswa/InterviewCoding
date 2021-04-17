public class RemoveLoop {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
		
	Node head;
	
	void deleteLoop() {
		Node slowPtr = head;
		Node fastPtr = head;
		Node prev = null;
		
		while(fastPtr != null && fastPtr.next != null) {
			prev = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr)
				break;
		}
		
		prev.next = null;
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
			
		newNode.next = head;
		head = newNode;
	}
		
	void printList(Node headRef) {
		Node temp = headRef;
			
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		RemoveLoop llist = new RemoveLoop();
		 
        llist.insert(20);
        llist.insert(4);
        llist.insert(15);
        llist.insert(10);
 
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
 
        llist.deleteLoop();

        llist.printList(llist.head);
	}

}
