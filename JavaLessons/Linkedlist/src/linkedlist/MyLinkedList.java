package linkedlist;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Stack;

public class MyLinkedList {
	//链表的头结点
	Node head = null;
	//链表中的节点，data代表节点的值，next是指向下一个节点的引用
	//链表添加结点：找到链表的末尾结点，把新的数据作为末尾结点的后续结点	
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
	//链表添加结点：输入为结点
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
	//链表删除结点：把要删除节点的前结点指向要删除结点的后结点，即直接跳过待删除结点
	public boolean deleteNode(int index) {
		if(index<1||index>length()) { //待删除结点不存在
			return false;
		}
		if(index==1) { //删除头结点
			head=head.next;
			return true;
		}
		Node preNode = head;
		Node curNode = preNode.next;
		int i = 1;
		while(curNode!=null) {
			if(i==index-1) { //寻找到待删除结点
				preNode.next = curNode.next; //待删除结点的前结点指向待删除结点的后结点
				return true;
			}
			// 当先结点和前结点同时向后移
			preNode = preNode.next;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
    // 通过index删除指定位置的结点，先找到准确位置。然后进行删除操作。
    // @param index：链表中的位置，从1开始 
    public void delNodeByIndex(int index){
        if(index<1 || index>length()){ //判断index是否合理
            return;
        }
        if(index==1) { //删除头结点
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
    // 求链表的长度
	public int length() {
		int length=0;
		Node curNode=head;
		while(curNode!=null) {
			length++;
			curNode=curNode.next;
		}
		return length;
	}
	// 链表结点排序，并返回排序后的头结点：
	// 选择排序算法，即每次都选出未排序结点中最小的结点，与第一个未排序结点交换
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
	// 打印结点
	public void printLink() {
		Node curNode=head;
		while(curNode!=null) {
			System.out.print(curNode.data+" ");
			curNode=curNode.next;
		}
		System.out.println();
	}
	// 去掉重复元素：需要额外的存储空间hashtable,调用hashtable.containsKey()来判断重复结点
	public void distinctLink() {
		Node temp=head;
		Node pre=null;
		Hashtable<Integer, Integer> hb = new Hashtable<Integer, Integer>();
		while(temp!=null) {
			if(hb.containsKey(temp.data)) { //如果hashtable中已存在该结点，则跳过该结点
				pre.next=temp.next;
			}else { //如果hashtable中不存在该结点，将结点存到hashtable中
				hb.put(temp.data, 1);
				pre=temp;
			}
			temp=temp.next;
		}
	}
	// 返回倒数第k个结点，
	// 两个指针，第一个指针向前移动k-1次，之后两个指针共同前进，当前面的指针到达末尾时，后面的指针所在的位置就是倒数第k个位置
	public Node findReverNode(int k) {
		if(k<1||k>length()) { //第k个结点不存在
			return null;
		}
		Node first=head;
		Node second=head;
		for(int i=0;i<k-1;i++) { //前移k-1步
			first=first.next;
		}
		while(first.next!=null) {
			first=first.next;
			second=second.next;
		}
		return second;
	}
	// 查找正数第k个元素
	public Node findNode(int k) {
		if(k<1||k>length()) { //不合法的k
			return null;
		}
		Node temp=head;
		for(int i=0;i<k-1;i++) {
			temp=temp.next;
		}
		return temp;
	}
	// 反转链表，再反转指针前。一定要保存下个结点的指针
	public void reserveLink() {
		Node curNode=head; //头结点
		Node preNode=null; //前一个结点
		while(curNode!=null) {
			Node nextNode=curNode.next; //保留下一个结点
			curNode.next=preNode; //指针反转
			preNode=curNode; //前结点后移
			curNode=nextNode; // 当前结点后移
		}
		head=preNode;
	}
	// 反向输出链表，三种方式：
	// 1、先反转链表，再输出链表，需要链表遍历两次，会破坏链表的结构，不建议
	// 2、把链表中的数字放入栈中再输出，需要维护额外的栈空间，显式用栈，是基于循环实现的，代码的鲁棒性要更好一些。
	// 3、依据2、中栈的思想，通过递归来实现，递归起始就是先执行的数据压入栈中，再一次出栈，当链表很长的时候，就会导致方法调用的层级很深，有可能造成栈溢出。
	public void reservePrt2(Node node) {
		Stack<Node> stack = new Stack<Node>(); //新建一个栈
		Node curNode=head;
		//将链表的所有结点压栈
		while (curNode!=null) {
			stack.push(curNode); //将当前结点压栈
			curNode=curNode.next;
		}
		//将栈中的结点打印输出
		while (stack.size() > 0) {
			System.out.print(stack.pop().data+" ");//出栈操作
		}
		System.out.println();
	}
	public void reservePrt3(Node node) {
		if(node!=null) {
			reservePrt3(node.next);
			System.out.print(node.data+" ");
		}
	}
	// 寻找单链表的中间结点：
	// 1、先求出链表的长度，再遍历1/2链表长度，寻找出链表的中间结点
	// 2、用两个指针遍历链表，一个快指针，一个慢指针，快指针每次向前移动2个结点，慢指针一次向前移动1个结点，当快指针移动到链表的末尾，慢指针所在的位置即为中间结点所在的位置
	public Node findMiddleNode() {
		Node slowPoint=head;
		Node quickPoint=head;
		//quickPoint.next == null是链表结点个数为奇数时，快指针已经走到最后了
        //quickPoint.next.next == null是链表结点数为偶数时，快指针已经走到倒数第二个结点了
        //链表结点个数为奇数时,返回的是中间结点；链表结点个数为偶数时，返回的是中间两个结点中的前一个
		while(quickPoint.next!=null && quickPoint.next.next!=null) {
			slowPoint=slowPoint.next;
			quickPoint=quickPoint.next.next;
		}
		return slowPoint;
	}
	// 判断链表是否有环：设置快指针和慢指针，慢指针每次走一步，快指针每次走两步，当快指针与慢指针相等，说明链表有环
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
	// 环的长度
	// 返回上方法相遇的结点。这个结点肯定在环中，让这个结点对应的指针一直往下走，直到它回到原点，算出环的长度。
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
	
	// 返回链表的最后一个结点
	public Node getLastNode() {
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp;
	}
	// 在不知道头结点的情况下删除指定结点：
	// 删除结点的重点在于找出其前结点，使其前结点的指针指向其后结点，即跳过待删除结点
	// 1.如果待删除结点是尾节点，由于单链表不知道其前结点，没有办法删除；2.如果删除的结点不是尾节点，则将其该结点的值与下一结点交换，然后该结点的指针指向下一节点的后续结点
	public boolean deleteSpecialNode(Node n) {
		if(n.next==null) {
			return false;
		}else {
			// 交换结点和其后续结点中的数据
			int temp=n.data;
			n.data=n.next.data;
			n.next.data=temp;
			// 删除后续节点
			n.next=n.next.next;
			return true;
		}
	}
	// 判断两个链表是否相交：两个链表相交，则他们的尾节点一定相同，比较两个链表的尾节点是否相同即可。在单链表中，只能从头结点开始顺序遍历，最后才能到达尾结点。
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
	// 如果链表相交，求链表相交的起始点：
	// 0、最后到达的尾节点却要先被比较：“先进后出”？利用栈解决这个问题：分别把两个链表的结点放入两个栈中，两个链表的尾结点位于两个栈的栈顶，接下来比较下一个栈顶，直到找到最后一个相同的结点。需要利用两个辅助栈，空间复杂度是O(len1+len2)，时间复杂度是O(len1+len2)。利用空间消耗换取时间效率。
	// 1、首先判断两个链表是否相交，如果两个链表不相交，则返回null
	// 2、求出两个链表的长度之差：len=length1-length2
	// 3、让较长的链表先走len步
	// 4、然后两个链表同步向前移动，每移动一次就比较结点是否相等，第一个相等的结点即为他们的第一个相交点
	public Node findFirstCrossPoint(MyLinkedList linkedList1,MyLinkedList linkedList2) {
		// 链表不相交
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
	// 在链表的指定位置插入结点。index:插入链表的位置，从1开始
	public void insertNodeByIndex(int index,int data) {
		// 判断指定位置是否合法
		Node newNode=new Node(data);
		if(index<1 && index>length()) {
			return;
		}
		int position=1; // 记录遍历到第几个结点了
		Node temp=head; // 可移动的指针
		while(head.next!=null) { // 遍历单链表
			if(index==position++) { // 判断是否到达指定位置。
				newNode.next=temp.next;
				temp.next=newNode;
				return;
			}
			temp=temp.next;
		}
	}
    // 合并有序单链表	
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
	// 合并有序单链表
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
			if(curNode.data==d) { //寻找到待删除结点
				preNode.next = curNode.next; //待删除结点的前结点指向待删除结点的后结点
				return true;
			}
			// 当先结点和前结点同时向后移
			preNode = preNode.next;
			curNode = curNode.next;
		}
		return false;
	}
	public void clear() {
		head=null;
	}
}
