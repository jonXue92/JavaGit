package linkedlist;

public class OrderLinkedList {
	Node head = null;
	public void insert(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node pre = null;
		Node temp = head;
		while (temp!=null && data > temp.data) {
			pre = temp;
			temp=temp.next;
		}
		if(pre==null) {
			head=newNode;
			head.next=temp;
		}else {
			pre.next=newNode;
			newNode.next=temp;
		}
	}
	public void printLink() {
		Node curNode=head;
		while(curNode!=null) {
			System.out.print(curNode.data+" ");
			curNode=curNode.next;
		}
		System.out.println();
	}
}
