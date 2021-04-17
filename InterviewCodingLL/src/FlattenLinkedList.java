
public class FlattenLinkedList {
	class Node{
		int data;
		Node right;
		Node down;
		
		Node(int d){
			this.data = d;
			this.right = null;
			this.down = null;
		}
	}
	
	Node head;
	
	Node merge(Node a, Node b) {
		if(a == null)
			return b;
		
		if(b == null)
			return a;
		
		Node result;
		
		if(a.data < b.data) {
			result = a;
			result.down = merge(a.down,b);
		}
		else {
			result = b;
			result.down = merge(a,b.down);
		}
		
		return result;
	}
	
	Node flatten(Node root) {
		if(root == null)
			return null;
		
		while(root.right != null) {
			Node next = root.right.right;
			root = merge(root,root.right);
			root.right = next;
		}
		
		return root;
	}
	
	Node insert(Node head_ref, int data) {
		
		Node newNode = new Node(data);
		
		newNode.down = head_ref;
		head_ref = newNode;
		
		return head_ref;
	}
	
	void printList() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data+"->");
			temp = temp.down;
		}
	}
	
	public static void main(String[] args) {
		
		FlattenLinkedList llist = new FlattenLinkedList();
		
		llist.head = llist.insert(llist.head,30);
		llist.head = llist.insert(llist.head,8);
		llist.head = llist.insert(llist.head,7);
		llist.head = llist.insert(llist.head,5);
		
		llist.head.right = llist.insert(llist.head.right,20);
		llist.head.right = llist.insert(llist.head.right,10);
		
		llist.head.right.right = llist.insert(llist.head.right.right,50);
		llist.head.right.right = llist.insert(llist.head.right.right,22);
		llist.head.right.right = llist.insert(llist.head.right.right,19);
		
		llist.head.right.right.right = llist.insert(llist.head.right.right.right,45);
		llist.head.right.right.right = llist.insert(llist.head.right.right.right,40);
		llist.head.right.right.right = llist.insert(llist.head.right.right.right,35);
		llist.head.right.right.right = llist.insert(llist.head.right.right.right,20);
		
		llist.head = llist.flatten(llist.head);
		llist.printList();
	}
}
