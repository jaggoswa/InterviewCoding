/* Time Complexity = O(n)
 * Space Complexity = O(1)*/
public class DetectLoopLL {
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	Node head;
	
	void detectLoop() {
		
		Node slow = head;
		Node fast = head;
		boolean flag = false;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				flag = true;
				break;
			}
		}
		
		if(flag)
			System.out.println("Loop found");
		else
			System.out.println("Loop not found");
		
		
	}
	
	void insert(int data) {
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {
		
		DetectLoopLL llist = new DetectLoopLL();
		
		llist.insert(20);
		llist.insert(4);
		llist.insert(15);
		llist.insert(10);
		
		int pos = 1, count = 0;
		Node loop = llist.head;
		Node end = llist.head;
		
		while(end.next != null) {
			end = end.next;
			
			if(count < pos) {
				loop = loop.next;
				count++;
			}
		}
		
		end.next = loop;
		
		llist.detectLoop();
	}

}
