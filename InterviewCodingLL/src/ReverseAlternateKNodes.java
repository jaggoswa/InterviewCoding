import java.util.Scanner;

/* Time Complexity = O(n)
 * Space Complexity = O(n)*/
public class ReverseAlternateKNodes {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	Node reverseAlternate(Node head,int k) {
		
		Node curr = head;
		Node prev = null, next = null;
		
			int count = 0;
			
		while(count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(head != null) {
			head.next = curr;
		}
		
		count = 0;
		while(count < k-1 && curr != null) {
			curr = curr.next;
			count++;
		}
		
		if(curr != null)
			curr.next = reverseAlternate(curr.next,k);
		
		return prev;
		
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
		ReverseAlternateKNodes llist = new ReverseAlternateKNodes();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the group size: ");
		int k = sc.nextInt();
		
		llist.insert(8);
		llist.insert(7);
		llist.insert(6);
		llist.insert(5);
		llist.insert(4);
		llist.insert(3);
		llist.insert(2);
		llist.insert(1);
		
		System.out.println("Original list");
		llist.printList();
		
		llist.head = llist.reverseAlternate(llist.head,k);
		
		System.out.println();
		System.out.println("Modified list");
		llist.printList();

	}

}
