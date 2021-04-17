
public class MergeAlternateLL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void merge(MergeAlternateLL q) {
		Node p_curr = head,q_curr = q.head;
		Node p_next = null, q_next = null;
		
		while(p_curr != null && q_curr != null) {
			p_next = p_curr.next;
			q_next = q_curr.next;
			
			p_curr.next = q_curr;
			q_curr.next = p_next;
			
			p_curr = p_next;
			q_curr = q_next;
		}
		
		q.head = q_curr;
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
		MergeAlternateLL llist1 = new MergeAlternateLL();
		MergeAlternateLL llist2 = new MergeAlternateLL();
		
		llist1.insert(3); 
        llist1.insert(2); 
        llist1.insert(1);
        
        System.out.println("First Linked List:"); 
        llist1.printList(); 
        
        llist2.insert(8); 
        llist2.insert(7); 
        llist2.insert(6); 
        llist2.insert(5); 
        llist2.insert(4); 
        
        System.out.println("\nSecond Linked List:"); 
        llist2.printList();
        
        llist1.merge(llist2); 
  
        System.out.println("\nModified first linked list:"); 
        llist1.printList(); 
  
        System.out.println("\nModified second linked list:"); 
        llist2.printList(); 
	}

}
