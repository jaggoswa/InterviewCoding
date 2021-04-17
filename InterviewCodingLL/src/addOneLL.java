
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
	
	void addOneWithCarry() {
		int carry = addOne(head);
		
		if(carry > 0) {
			Node newNode = new Node(carry);
			newNode.next = head;
			head = newNode;
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
		
		addOneLL llist = new addOneLL();
		
		llist.insert(9);
		llist.insert(9);
		llist.insert(9);
		llist.insert(9);
		
		llist.addOneWithCarry();
		
		llist.printList();
	}

}
