package linkedlist;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Stack;

public class MyLinkedList {
	//�����ͷ���
	Node head = null;
	//�����еĽڵ㣬data����ڵ��ֵ��next��ָ����һ���ڵ������
	//������ӽ�㣺�ҵ������ĩβ��㣬���µ�������Ϊĩβ���ĺ������	
	public void addNode(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node temp=head;
		while (temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
	}
	//������ӽ�㣺����Ϊ���
	public void add(Node node) {
		if(head==null) {
			head=node;
			return;
		}
		Node temp=head;
		while (temp.next!=null) {
			temp=temp.next;
		}
		temp.next=node;
	}
	//����ɾ����㣺��Ҫɾ���ڵ��ǰ���ָ��Ҫɾ�����ĺ��㣬��ֱ��������ɾ�����
	public boolean deleteNode(int index) {
		if(index<1||index>length()) { //��ɾ����㲻����
			return false;
		}
		if(index==1) { //ɾ��ͷ���
			head=head.next;
			return true;
		}
		Node preNode = head;
		Node curNode = preNode.next;
		int i = 1;
		while(curNode!=null) {
			if(i==index-1) { //Ѱ�ҵ���ɾ�����
				preNode.next = curNode.next; //��ɾ������ǰ���ָ���ɾ�����ĺ���
				return true;
			}
			// ���Ƚ���ǰ���ͬʱ�����
			preNode = preNode.next;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
    // ͨ��indexɾ��ָ��λ�õĽ�㣬���ҵ�׼ȷλ�á�Ȼ�����ɾ��������
    // @param index�������е�λ�ã���1��ʼ 
    public void delNodeByIndex(int index){
        if(index<1 || index>length()){ //�ж�index�Ƿ����
            return;
        }
        if(index==1) { //ɾ��ͷ���
			head=head.next;
			return;
		}
        int position=1;
        Node temp = head;
        while(temp.next != null){
            if(index == position+1){
                temp.next = temp.next.next;    
            	return;
            }
            position++;
            temp = temp.next;
        }    
    }
    // ������ĳ���
	public int length() {
		int length=0;
		Node curNode=head;
		while(curNode!=null) {
			length++;
			curNode=curNode.next;
		}
		return length;
	}
	// ���������򣬲�����������ͷ��㣺
	// ѡ�������㷨����ÿ�ζ�ѡ��δ����������С�Ľ�㣬���һ��δ�����㽻��
	public Node linkSort() {
		Node curNode = head;
		while(curNode!=null) {
			Node nextNode = curNode.next;
			while(nextNode!=null) {
				if(curNode.data > nextNode.data) {
					int temp=curNode.data;
					curNode.data=nextNode.data;
					nextNode.data=temp;
				}
				nextNode=nextNode.next;
			}
			curNode=curNode.next;
		}
		return head;
	}
	// ��ӡ���
	public void printLink() {
		Node curNode=head;
		while(curNode!=null) {
			System.out.print(curNode.data+" ");
			curNode=curNode.next;
		}
		System.out.println();
	}
	// ȥ���ظ�Ԫ�أ���Ҫ����Ĵ洢�ռ�hashtable,����hashtable.containsKey()���ж��ظ����
	public void distinctLink() {
		Node temp=head;
		Node pre=null;
		Hashtable<Integer, Integer> hb = new Hashtable<Integer, Integer>();
		while(temp!=null) {
			if(hb.containsKey(temp.data)) { //���hashtable���Ѵ��ڸý�㣬�������ý��
				pre.next=temp.next;
			}else { //���hashtable�в����ڸý�㣬�����浽hashtable��
				hb.put(temp.data, 1);
				pre=temp;
			}
			temp=temp.next;
		}
	}
	// ���ص�����k����㣬
	// ����ָ�룬��һ��ָ����ǰ�ƶ�k-1�Σ�֮������ָ�빲ͬǰ������ǰ���ָ�뵽��ĩβʱ�������ָ�����ڵ�λ�þ��ǵ�����k��λ��
	public Node findReverNode(int k) {
		if(k<1||k>length()) { //��k����㲻����
			return null;
		}
		Node first=head;
		Node second=head;
		for(int i=0;i<k-1;i++) { //ǰ��k-1��
			first=first.next;
		}
		while(first.next!=null) {
			first=first.next;
			second=second.next;
		}
		return second;
	}
	// ����������k��Ԫ��
	public Node findNode(int k) {
		if(k<1||k>length()) { //���Ϸ���k
			return null;
		}
		Node temp=head;
		for(int i=0;i<k-1;i++) {
			temp=temp.next;
		}
		return temp;
	}
	// ��ת�����ٷ�תָ��ǰ��һ��Ҫ�����¸�����ָ��
	public void reserveLink() {
		Node curNode=head; //ͷ���
		Node preNode=null; //ǰһ�����
		while(curNode!=null) {
			Node nextNode=curNode.next; //������һ�����
			curNode.next=preNode; //ָ�뷴ת
			preNode=curNode; //ǰ������
			curNode=nextNode; // ��ǰ������
		}
		head=preNode;
	}
	// ��������������ַ�ʽ��
	// 1���ȷ�ת���������������Ҫ����������Σ����ƻ�����Ľṹ��������
	// 2���������е����ַ���ջ�����������Ҫά�������ջ�ռ䣬��ʽ��ջ���ǻ���ѭ��ʵ�ֵģ������³����Ҫ����һЩ��
	// 3������2����ջ��˼�룬ͨ���ݹ���ʵ�֣��ݹ���ʼ������ִ�е�����ѹ��ջ�У���һ�γ�ջ��������ܳ���ʱ�򣬾ͻᵼ�·������õĲ㼶����п������ջ�����
	public void reservePrt2(Node node) {
		Stack<Node> stack = new Stack<Node>(); //�½�һ��ջ
		Node curNode=head;
		//����������н��ѹջ
		while (curNode!=null) {
			stack.push(curNode); //����ǰ���ѹջ
			curNode=curNode.next;
		}
		//��ջ�еĽ���ӡ���
		while (stack.size() > 0) {
			System.out.print(stack.pop().data+" ");//��ջ����
		}
		System.out.println();
	}
	public void reservePrt3(Node node) {
		if(node!=null) {
			reservePrt3(node.next);
			System.out.print(node.data+" ");
		}
	}
	// Ѱ�ҵ�������м��㣺
	// 1�����������ĳ��ȣ��ٱ���1/2�����ȣ�Ѱ�ҳ�������м���
	// 2��������ָ���������һ����ָ�룬һ����ָ�룬��ָ��ÿ����ǰ�ƶ�2����㣬��ָ��һ����ǰ�ƶ�1����㣬����ָ���ƶ��������ĩβ����ָ�����ڵ�λ�ü�Ϊ�м������ڵ�λ��
	public Node findMiddleNode() {
		Node slowPoint=head;
		Node quickPoint=head;
		//quickPoint.next == null�����������Ϊ����ʱ����ָ���Ѿ��ߵ������
        //quickPoint.next.next == null����������Ϊż��ʱ����ָ���Ѿ��ߵ������ڶ��������
        //���������Ϊ����ʱ,���ص����м��㣻���������Ϊż��ʱ�����ص����м���������е�ǰһ��
		while(quickPoint.next!=null && quickPoint.next.next!=null) {
			slowPoint=slowPoint.next;
			quickPoint=quickPoint.next.next;
		}
		return slowPoint;
	}
	// �ж������Ƿ��л������ÿ�ָ�����ָ�룬��ָ��ÿ����һ������ָ��ÿ��������������ָ������ָ����ȣ�˵�������л�
	public boolean isRinged() {
		if(head==null) {
			return false;
		}
		Node slow=head;
		Node fast=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}
	public boolean checkLoop() {
		if (head==null) {
			return false;
		}
		Node temp=head;
		Set<Integer> set=new HashSet<Integer>();
		while(temp!=null) {
			if(set.contains(temp.data)) {
				return true;
			}else{
				set.add(temp.data);
			}
			temp=temp.next;
		}
		return false;
	}
	// ���ĳ���
	// �����Ϸ��������Ľ�㡣������϶��ڻ��У����������Ӧ��ָ��һֱ�����ߣ�ֱ�����ص�ԭ�㣬������ĳ��ȡ�
	public int getCyclelength() {
		if (head==null) {
			return 0;
		}
		Node slow=head;
		Node fast=head;
		Node curNode=null;
		Node temp=null;
		int length=0;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(fast == slow) {
				temp=fast;
				curNode=fast;
				while (curNode!=null) {
					curNode=curNode.next;
					length++;
					if (curNode==temp) {
						return length;
					}
				}
			}
		}
		return length;
	}
	
	// ������������һ�����
	public Node getLastNode() {
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp;
	}
	// �ڲ�֪��ͷ���������ɾ��ָ����㣺
	// ɾ�������ص������ҳ���ǰ��㣬ʹ��ǰ����ָ��ָ������㣬��������ɾ�����
	// 1.�����ɾ�������β�ڵ㣬���ڵ�����֪����ǰ��㣬û�а취ɾ����2.���ɾ���Ľ�㲻��β�ڵ㣬����ý���ֵ����һ��㽻����Ȼ��ý���ָ��ָ����һ�ڵ�ĺ������
	public boolean deleteSpecialNode(Node n) {
		if(n.next==null) {
			return false;
		}else {
			// �����������������е�����
			int temp=n.data;
			n.data=n.next.data;
			n.next.data=temp;
			// ɾ�������ڵ�
			n.next=n.next.next;
			return true;
		}
	}
	// �ж����������Ƿ��ཻ�����������ཻ�������ǵ�β�ڵ�һ����ͬ���Ƚ����������β�ڵ��Ƿ���ͬ���ɡ��ڵ������У�ֻ�ܴ�ͷ��㿪ʼ˳������������ܵ���β��㡣
	public boolean isCross(Node head1,Node head2) {
		Node temp1=head1;
		Node temp2=head2;
		while (temp1.next!=null) {
			temp1=temp1.next;
		}
		while (temp2.next!=null) {
			temp2=temp2.next;
		}
		if (temp1==temp2) {
			return true;
		}
		return false;
	}
	// ��������ཻ���������ཻ����ʼ�㣺
	// 0����󵽴��β�ڵ�ȴҪ�ȱ��Ƚϣ����Ƚ������������ջ���������⣺�ֱ����������Ľ���������ջ�У����������β���λ������ջ��ջ�����������Ƚ���һ��ջ����ֱ���ҵ����һ����ͬ�Ľ�㡣��Ҫ������������ջ���ռ临�Ӷ���O(len1+len2)��ʱ�临�Ӷ���O(len1+len2)�����ÿռ����Ļ�ȡʱ��Ч�ʡ�
	// 1�������ж����������Ƿ��ཻ��������������ཻ���򷵻�null
	// 2�������������ĳ���֮�len=length1-length2
	// 3���ýϳ�����������len��
	// 4��Ȼ����������ͬ����ǰ�ƶ���ÿ�ƶ�һ�ξͱȽϽ���Ƿ���ȣ���һ����ȵĽ�㼴Ϊ���ǵĵ�һ���ཻ��
	public Node findFirstCrossPoint(MyLinkedList linkedList1,MyLinkedList linkedList2) {
		// �����ཻ
		if(!isCross(linkedList1.head,linkedList2.head)) {
			return null;
		}else {
			int length1=linkedList1.length();
			int length2=linkedList2.length();
			Node temp1=linkedList1.head;
			Node temp2=linkedList2.head;
			int len=length1-length2;
			if(len>0) {
				for(int i=0;i<len;i++) {
					temp1=temp1.next;
				}
			}else {
				for(int i=0;i<len;i++) {
					temp2=temp2.next;
				}
			}
			while(temp1!=temp2) {
				temp1=temp1.next;
				temp2=temp2.next;
			}
			return temp1;
		}
	}
	// �������ָ��λ�ò����㡣index:���������λ�ã���1��ʼ
	public void insertNodeByIndex(int index,int data) {
		// �ж�ָ��λ���Ƿ�Ϸ�
		Node newNode=new Node(data);
		if(index<1 && index>length()) {
			return;
		}
		int position=1; // ��¼�������ڼ��������
		Node temp=head; // ���ƶ���ָ��
		while(head.next!=null) { // ����������
			if(index==position++) { // �ж��Ƿ񵽴�ָ��λ�á�
				newNode.next=temp.next;
				temp.next=newNode;
				return;
			}
			temp=temp.next;
		}
	}
    // �ϲ���������	
	public MyLinkedList mergeLinkedList0(MyLinkedList linkedlist1, MyLinkedList linkedlist2) {
		MyLinkedList resultLinkedList = new MyLinkedList();
		Node head1=linkedlist1.head;
		Node head2=linkedlist2.head;
		Node rLLhead=null;
		Node curNode=null;
		if (head1 == null && head2 == null) {
			return null;
		}
		if (head1 == null) {
			return linkedlist2;
		}
		if (head2 == null) {
			return linkedlist1;
		}
		if (head1.data<head2.data) {
			rLLhead=head1;
			curNode=head1;
			head1=head1.next;
		} else {
			rLLhead=head2;
			curNode=head2;
			head2=head2.next;
		}
		while (head1 != null && head2 != null) {
			if (head1.data<head2.data) {
				curNode.next=head1;
				curNode=curNode.next;
				head1=head1.next;
			} else {
				curNode.next=head2;
				curNode=curNode.next;
				head2=head2.next;
			}
		}
		if (head1 != null) {
			curNode.next=head1;
			}
		if (head2 != null) {
			curNode.next=head2;
			}
		resultLinkedList.head=rLLhead;
		return resultLinkedList;
	}
	// �ϲ���������
	public Node mergeLinkedList(Node head1,Node head2) {
		if (head1 == null && head2 == null) {
			return null;
		}
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node temp;
		Node curNode;
		if (head1.data<head2.data) {
			temp=head1;
			curNode=head1;
			head1=head1.next;
		}else {
			temp=head2;
			curNode=head2;
			head2=head2.next;
		}
		while (head1 !=null && head2 != null) {
			if (head1.data<head2.data) {
				curNode.next=head1;
				curNode=curNode.next;
				head1=head1.next;
			}else {
				curNode.next=head2;
				curNode=curNode.next;
				head2=head2.next;
			}
		}
		if(head1!=null) {
			curNode.next=head1;
		}
		if(head2!=null) {
			curNode.next=head2;
		}
		return temp;
	}
	public Node find(int d) {
		Node temp=head;
		if (temp==null) {
			return null;
		}
		while(temp!=null) {
			if(temp.data==d) {
				return temp;
			}
			temp=temp.next;
		}
		return null;
	}
	public boolean delNodeByData(int d) {
		if(head==null) {
			return false;
		}
		if(head.data==d) {
			head=head.next;
			return true;
		}
		Node preNode=head;
		Node curNode=preNode.next;
		while(curNode!=null) {
			if(curNode.data==d) { //Ѱ�ҵ���ɾ�����
				preNode.next = curNode.next; //��ɾ������ǰ���ָ���ɾ�����ĺ���
				return true;
			}
			// ���Ƚ���ǰ���ͬʱ�����
			preNode = preNode.next;
			curNode = curNode.next;
		}
		return false;
	}
	public void clear() {
		head=null;
	}
}
