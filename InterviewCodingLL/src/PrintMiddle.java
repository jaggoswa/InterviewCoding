/* Time Complexity = O(n), although it will always have to traverse just n/2 nodes 
 * to find the middle node
 * Space Complexity = O(1)
 */
public class PrintMiddle {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void printMiddleNode() {
		
		Node slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		System.out.println("The middle node is: " + slow.data);
		
	}
	
	void insert(int data) {
		
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	void printList() {
		
		Node temp = head;
		
		System.out.println("The original list is:");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		PrintMiddle llist = new PrintMiddle();
		
		//llist.insert(7);
		llist.insert(6);
		llist.insert(5);
		llist.insert(4);
		llist.insert(3);
		llist.insert(2);
		llist.insert(1);
		
		llist.printList();
		llist.printMiddleNode();
		
	}

}
