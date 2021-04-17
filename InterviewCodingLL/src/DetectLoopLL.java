
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
	
	void detectLoop(){
		Node slowPtr = head;
		Node fastPtr = head;
		boolean flag = false;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr) {
				flag = true;
				break;
			}
		}
		
		if(flag)
			System.out.print("Loop Detected");
		else
			System.out.print("No Loop Detected");
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
