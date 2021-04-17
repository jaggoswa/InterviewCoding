
public class RemoveMiddleElement {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void remove() {
		Node slowPtr = head;
		Node fastPtr = head;
		Node prev = null;
		
		while(fastPtr != null && fastPtr.next != null) {
			prev = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		prev.next = slowPtr.next;
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	void printList() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RemoveMiddleElement llist = new RemoveMiddleElement();
		
//		llist.insert(6);
		llist.insert(5);
		llist.insert(4);
		llist.insert(3);
		llist.insert(2);
		llist.insert(1);
		
		System.out.println("The original linked list is:");
		llist.printList();
		
		llist.remove();
		
		System.out.println("The modified linked list is:");
		llist.printList();
		

	}

}
