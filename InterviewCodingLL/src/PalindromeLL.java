import java.util.*;

public class PalindromeLL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	Node reverse(Node secondHalfPtr) {
		Node prev = null, next = null;
		Node curr = secondHalfPtr;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		secondHalfPtr = prev;
		
		return secondHalfPtr;
	}
	
	boolean compareLists(Node head1, Node head2) {
		
		Node temp1 = head1;
		Node temp2 = head2;
		
		while(temp1 != null && temp2 != null) {
			if(temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			else
				return false;
		}
		
		if(temp1 == null && temp2 == null)
			return true;
		
		return false;
	}
	
	void isPalindrome() {
		Node secondHalfPtr = null, midNode = null, prevOfSlowPtr = null;
		Node slowPtr = head, fastPtr = head;
		boolean isPal = false;
		
		if(fastPtr == null || fastPtr.next == null) {
			System.out.println("The list is a palindrome");
			return;
		}
		
		while(fastPtr != null && fastPtr.next != null) {
			prevOfSlowPtr = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		if(fastPtr != null) {
			midNode = slowPtr;
			slowPtr = slowPtr.next;
		}
		
		prevOfSlowPtr.next = null;
		secondHalfPtr = reverse(slowPtr);
		
		isPal = compareLists(head,secondHalfPtr);
		
		secondHalfPtr = reverse(secondHalfPtr);
		
		if(midNode != null) {
			prevOfSlowPtr.next = midNode;
			midNode.next = secondHalfPtr;
		}
		else
			prevOfSlowPtr.next = secondHalfPtr;
		
		if(isPal)
			System.out.println("The list is a palindrome");
		else
			System.out.println("The list is not a palindrome");
			
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	void printLsit() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
		PalindromeLL llist = new PalindromeLL();
		
		llist.insert(1);
//		llist.insert(2);
//		llist.insert(2);
//		llist.insert(1);
//		llist.insert(1);
		
		llist.isPalindrome();
		llist.printLsit();

	}

}
