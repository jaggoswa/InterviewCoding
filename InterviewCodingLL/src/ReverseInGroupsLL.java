import java.util.Scanner;

/* Time Complexity = O(n)
 * Space Complexity = O(n/k)*/
public class ReverseInGroupsLL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	Node reverseUtil(Node head,int k) {
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
		
		if(next != null) 
			head.next = reverseUtil(next,k);
		
		return prev;
	}
	
//	Node reverseInGroups(int k) {
//		head = reverseUtil(head,k);
//		
//		return head;
//	}
	
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
		
		ReverseInGroupsLL llist = new ReverseInGroupsLL();
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
		
		llist.head = llist.reverseUtil(llist.head,k);
		
		llist.printList();
	}

}
