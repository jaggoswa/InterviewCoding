import java.util.*;

//Delete continuous nodes with sum K from a given linked list
public class RemoveKSumLL {
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	Node removeKSumSublists(Node head){
		Node dummy = new Node(0);
		dummy.next = head;
		
		Map<Integer,Node> pSumMap = new HashMap<Integer,Node>();
		pSumMap.put(0, dummy);
		
		int pSum = 0;
		
		while(head != null) {
			pSum += head.data;
			
			if(pSumMap.containsKey(pSum)) {
				Node temp = pSumMap.get(pSum);
				Node toRemove = temp.next;
				int sum = pSum;
				
				while(toRemove != head) {
					sum += toRemove.data;
					pSumMap.remove(sum);
					toRemove = toRemove.next;
				}
				
				temp.next = head.next;
			}
			else {
				pSumMap.put(pSum,head);
			}
			
			head = head.next;
		}
		
		return dummy.next;
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	void printList(Node headRef) {
		Node temp = headRef;
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		RemoveKSumLL llist = new RemoveKSumLL();
		
		llist.insert(1);
		llist.insert(4);
		llist.insert(-3);
		llist.insert(2);
		llist.insert(1);
		
		Node newList = llist.removeKSumSublists(llist.head);
		
		llist.printList(newList);
	}
}
