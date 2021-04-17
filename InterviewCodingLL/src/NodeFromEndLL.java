
public class NodeFromEndLL {
	
	class Node {
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void findNodeFromEnd(int n) {
		Node tempPtr = head;
		Node mainPtr = head;
		
		int count = 0;
		
		while(count < n) {
			if(tempPtr != null)
				tempPtr = tempPtr.next;
			else {
				System.out.print("The position given is greater than number of elements in the list");
				return;
			}
			count++;
		}
		
		while(tempPtr != null) {
			mainPtr = mainPtr.next;
			tempPtr = tempPtr.next;
		}
		
		System.out.printf("The element at position %d from end of the list is %s",n,mainPtr.data);
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	void printList() {
		Node temp = head;
		
		System.out.println("The linked list is:");
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		NodeFromEndLL llist = new NodeFromEndLL();
		
		llist.insert(5);
		llist.insert(4);
		llist.insert(3);
		llist.insert(2);
		llist.insert(1);
		
		llist.printList();
		
		llist.findNodeFromEnd(7);
	}
}
