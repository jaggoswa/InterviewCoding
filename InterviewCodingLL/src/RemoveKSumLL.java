import java.util.*;

//Delete continuous nodes with sum K from a given linked list

/* Time Complexity = O(n)
 * Space Complexity = O(n)
 */

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
	
	//dummy,1,2,-3,4,5
	//dummy,1,2,3,-5,6
	
	Node removeKSumSublists(Node head,int k){
		Node dummy = new Node(0);
		dummy.next = head;
		
		Map<Integer,Node> pSumMap = new HashMap<Integer,Node>();
		pSumMap.put(0, dummy);
		
		int pSum = 0;
		
		while(head != null) {
			pSum += head.data;
			
			if(pSumMap.containsKey(pSum - k)) {
				Node temp = pSumMap.get(pSum - k);
				Node toRemove = temp.next;
				int sum = pSum - k;
				
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
			System.out.print(temp.data + " ");
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
		
		Node newList = llist.removeKSumSublists(llist.head,-1);
		
		llist.printList(newList);
	}
}
