package linkedlist;

public class TwowayLinkedList {
	TwowayNode head=null;
	TwowayNode tail=null;
	//������ͷ���ӽ��
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
	//��β���ӽڵ�
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
	//ɾ������ͷ
	public TwowayNode deleteHead() {
		TwowayNode temp=head;
		if(head!=null) {
			head=head.next;
			head.prev=null;
		}
		return temp;
	}
	//ɾ������β
	public TwowayNode deleteTail() {
		TwowayNode temp=tail;
		if(tail!=null) {
			tail=tail.prev;
			tail.next=null;
		}
		return temp;
	}
	//ɾ��ֵΪd�Ľ��
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
	//�޸�
	public void updata(int d,int da) {
		TwowayNode temp=head;
		while(temp!=null) {
			if(temp.data==d) {
				temp.data=da;
			}
			temp=temp.next;
		}	
	}
	//�������Ľ�����
	public int getSize() {
		int length=0;
		TwowayNode curNode=head;
		while(curNode!=null) {
			length++;
			curNode=curNode.next;
		}
		return length;
	}
	//��ӡ����
	public void display() {
		TwowayNode temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
