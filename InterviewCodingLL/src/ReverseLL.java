
public class ReverseLL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void reverse() {
		Node curr = head;
		Node prev = null, next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		head = prev;
	}

	void insert(int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	void printLsit() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		
		ReverseLL llist = new ReverseLL();
		
		llist.insert(6);
		llist.insert(5);
		llist.insert(4);
		llist.insert(3);
		llist.insert(2);
		llist.insert(1);
		
		llist.reverse();
		
		llist.printLsit();
	}

}
