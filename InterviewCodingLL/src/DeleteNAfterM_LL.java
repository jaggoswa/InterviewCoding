
public class DeleteNAfterM_LL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void skipMdeleteN(int M, int N) {
		Node curr = head;
		int count;
		
		while(curr != null) {
			for(count = 1;count < M && curr != null;count++)
				curr = curr.next;
			
			if(curr == null)
				return;
			
			Node temp = curr.next;
			
			for(count = 1;count <= N && temp != null;count++)
				temp = temp.next;
			
			curr.next = temp;
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
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		DeleteNAfterM_LL llist = new DeleteNAfterM_LL();
		
		llist.insert(10);
		llist.insert(9);
		llist.insert(8);
		llist.insert(7);
		llist.insert(6);
		llist.insert(5);
		llist.insert(4);
		llist.insert(3);
		llist.insert(2);
		llist.insert(1);
		
		System.out.println("The original list is:");
		llist.printList();
		
		llist.skipMdeleteN(3,2);
		
		System.out.println("\n The list after modification is:");
		llist.printList();
	}

}
