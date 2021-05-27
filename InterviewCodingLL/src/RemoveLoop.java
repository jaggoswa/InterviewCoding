public class RemoveLoop {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
		
	Node head;
	
	void deleteLoop() {
		
		// If list is empty or has only one node
        // without loop
        if (head == null || head.next == null)
            return;
 
        Node slow = head, fast = head;
 
        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;
 
        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;
 
            slow = slow.next;
            fast = fast.next.next;
        }
 
        /* If loop exists */
        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
 
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
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
	}

	public static void main(String[] args) {
		RemoveLoop llist = new RemoveLoop();
		 
        llist.insert(20);
        llist.insert(4);
        llist.insert(15);
        llist.insert(10);
 
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head.next;
 
        llist.deleteLoop();

        llist.printList();
	}

}
