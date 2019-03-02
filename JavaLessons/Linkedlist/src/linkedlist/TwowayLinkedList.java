package linkedlist;

public class TwowayLinkedList {
	TwowayNode head=null;
	TwowayNode tail=null;
	//在链表头增加结点
	public void addHead(int data) {
		TwowayNode newNode=new TwowayNode(data);
		if(head==null && tail==null) {
			head=newNode;
			tail=newNode;
		}else {
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
		}
	}
	//链尾增加节点
	public void addTail(int data) {
		TwowayNode newNode = new TwowayNode(data);
		if(head==null && tail==null) {
			head=newNode;
			tail=newNode;
		}else {
			newNode.prev=tail;
			tail.next=newNode;
			tail=newNode;
		}
	}
	public int search(int d) {
		TwowayNode temp=head;
		int i=0;
		if(temp==null) {
			return 0;
		}
		while (temp!=null) {
			i++;
			if(temp.data==d) {
				return i;
			}
			temp=temp.next;
		}
		return 0;
	}
	//删除链表头
	public TwowayNode deleteHead() {
		TwowayNode temp=head;
		if(head!=null) {
			head=head.next;
			head.prev=null;
		}
		return temp;
	}
	//删除链表尾
	public TwowayNode deleteTail() {
		TwowayNode temp=tail;
		if(tail!=null) {
			tail=tail.prev;
			tail.next=null;
		}
		return temp;
	}
	//删除值为d的结点
	public void removebyvalue(int d) {
		TwowayNode temp=head;
		while(temp!=null) {
			if(temp.data==d) {
				if(temp==head) {
					head=head.next;
					head.prev=null;					
				}else if(temp==tail) {
					tail=tail.prev;
					tail.next=null;
				}else {
					temp.prev.next=temp.next;
					temp.next.prev=temp.prev;
				}
			}
			temp=temp.next;
		}	
	}
	//修改
	public void updata(int d,int da) {
		TwowayNode temp=head;
		while(temp!=null) {
			if(temp.data==d) {
				temp.data=da;
			}
			temp=temp.next;
		}	
	}
	//获得链表的结点个数
	public int getSize() {
		int length=0;
		TwowayNode curNode=head;
		while(curNode!=null) {
			length++;
			curNode=curNode.next;
		}
		return length;
	}
	//打印链表
	public void display() {
		TwowayNode temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
