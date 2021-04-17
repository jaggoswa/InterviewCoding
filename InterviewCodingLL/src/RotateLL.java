
public class RotateLL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void rotate(int k) {
		if(k == 0)
			return;
		
		int count = 1;
		Node current = head;
		
		while(count < k && current != null) {
			current = current.next;
			count++;
		}
		
		if(current == null)
			return;
		
		Node kthNode = current;
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = head;
		head = kthNode.next;
		kthNode.next = null;	
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
		
		RotateLL llist = new RotateLL();
		
		llist.insert(60);
		llist.insert(50);
		llist.insert(40);
		llist.insert(30);
		llist.insert(20);
		llist.insert(10);
		
		System.out.println("The original list is:");
		llist.printList();
		
		llist.rotate(4);
		
		System.out.println("\nThe list after rotation is:");
		llist.printList();
	}

}
