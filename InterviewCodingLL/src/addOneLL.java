
public class addOneLL {
	
	class Node {
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	int addOne(Node head) {
		if(head == null)
			return 1;
		
		int sum = head.data + addOne(head.next);
		
		head.data = sum%10;
		return sum/10;
	}
	
	/* Time Complexity = O(n)
	 * Space Complexity = O(1)*/
	void addOneWithCarry() {
		int carry = addOne(head);
		
		if(carry > 0) {
			Node newNode = new Node(carry);
			newNode.next = head;
			head = newNode;
		}
	}

/* Time Complexity = O(n)
 * Space Complexity = O(1)*/	
//	Node addOneWithCarry1(Node head) {
//		
//		Node sentinel = new Node(0);
//		sentinel.next = head;
//		Node notNine = sentinel;
//		
//		while(head != null) {
//			if(head.data != 9) {
//				notNine = head;
//			}
//			
//			head = head.next;
//		}
//		
//		notNine.data++;
//		Node nine = notNine.next;
//		
//		while(nine != null) {
//			nine.data = 0;
//			nine = nine.next;
//		}
//		
//		return sentinel.data != 0 ? sentinel : sentinel.next;
//		
//	}
	
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
		
		addOneLL llist = new addOneLL();
		
		llist.insert(9);
		llist.insert(9);
		llist.insert(9);
		llist.insert(9);
		
		llist.addOneWithCarry();
		
		llist.printList();
	}

}
