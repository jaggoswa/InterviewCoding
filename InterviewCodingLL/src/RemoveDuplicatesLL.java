
public class RemoveDuplicatesLL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void removeDuplicates() {
		Node curr = head;
		
		while(curr != null && curr.next != null) {
			if(curr.data == curr.next.data) {
				curr.next = curr.next.next;
			}
			else
				curr = curr.next;
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
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicatesLL llist = new RemoveDuplicatesLL();
		
		llist.insert(60);
		llist.insert(43);
		llist.insert(43);
		llist.insert(21);
		llist.insert(11);
		llist.insert(11);
		llist.insert(11);
		
		llist.removeDuplicates();
		llist.printList();

	}

}
