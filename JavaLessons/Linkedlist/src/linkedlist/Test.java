package linkedlist;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyLinkedList myLinkedList = new MyLinkedList();
//		// 添加链表结点
//		myLinkedList.addNode(9);
//		myLinkedList.addNode(8);
//		myLinkedList.addNode(6);
//		myLinkedList.addNode(3);
//		myLinkedList.addNode(5);
//		// 打印链表
//		myLinkedList.printLink();
//		// 测试链表结点个数
//		System.out.println(myLinkedList.length());
//		// 链表排序
//		Node head = myLinkedList.linkSort();
//		System.out.println(head.data);
//		myLinkedList.printLink();
//		// 去除重复结点
//		myLinkedList.distinctLink();
//		myLinkedList.printLink();
//		// 链表反转
//		myLinkedList.reserveLink();
//		myLinkedList.printLink();
//		// 倒序输出/遍历链表
//		myLinkedList.reservePrt3(myLinkedList.head);
//		System.out.println();
//		// 返回链表的中间结点
//		Node middleNode = myLinkedList.findMiddleNode();
//		System.out.println(middleNode.data);
//		// 判断链表是否有环
//		boolean isRinged=myLinkedList.isRinged();
//		System.out.println(isRinged);
//		// 将链表的最后一个结点指向头结点，制造有环的效果
//		Node lastNode = myLinkedList.getLastNode();
//		lastNode.next=myLinkedList.head;
//		isRinged=myLinkedList.isRinged();
//		System.out.println(isRinged);
//		// 删除指定结点
//		Node nk=myLinkedList.findReverNode(3);
//		System.out.println(nk.data);
//		myLinkedList.deleteSpecialNode(nk);
//		myLinkedList.printLink();
//		// 链表是否相交
//		// 新链表
//		MyLinkedList myLinkedList1 = new MyLinkedList();
//		myLinkedList1.addNode(1);
//		myLinkedList1.addNode(2);
//		myLinkedList1.printLink();
//		System.out.println(myLinkedList.isCross(myLinkedList.head, myLinkedList1.head));
//		// 把第一个链表从第三个结点开始接在第二个链表的后面，制造相交的效果
//		myLinkedList1.findNode(2).next=myLinkedList.findNode(3);
//		myLinkedList1.printLink();
//		System.out.println(myLinkedList.isCross(myLinkedList.head, myLinkedList1.head));
//		// 如果两个链表相交，求链表相交的结点的值
//		Node n = myLinkedList1.findFirstCrossPoint(myLinkedList, myLinkedList1);
//		if (n==null) {
//			System.out.println("No!");
//		}else {
//			System.out.println(n.data);
//		}
		MyLinkedList myLinkedList2 = new MyLinkedList();
		for (int i=1;i<=10;i++) {
			myLinkedList2.addNode(i);
		}
		myLinkedList2.printLink();
//		System.out.println(myLinkedList2.find(3).data);
		myLinkedList2.delNodeByData(3);
		myLinkedList2.printLink();
		myLinkedList2.insertNodeByIndex(4, 11);
		myLinkedList2.printLink();
		System.out.println(myLinkedList2.checkLoop());
//		myLinkedList2.deleteNode(8);
//		myLinkedList2.printLink();
//		System.out.println(myLinkedList2.findNode(6).data);
//		myLinkedList2.delNodeByIndex(2);
//		myLinkedList2.printLink();
//		System.out.println(myLinkedList2.findReverNode(4).data);
//		MyLinkedList myLinkedList3 = new MyLinkedList();
//		myLinkedList3.addNode(2);
//		myLinkedList3.addNode(7);
//		myLinkedList3.printLink();
//		System.out.println(myLinkedList3.findMiddleNode().data);
//		MyLinkedList myLinkedList4 = new MyLinkedList();
//		myLinkedList4.head=myLinkedList4.mergeLinkedList(myLinkedList2.head, myLinkedList3.head);
//		myLinkedList4=myLinkedList4.mergeLinkedList0(myLinkedList2, myLinkedList3);
//		myLinkedList4.printLink();
//		myLinkedList2.reservePrt2(myLinkedList2.head);
//		myLinkedList2.reservePrt3(myLinkedList2.head);
//		System.out.println();
//		System.out.println(myLinkedList2.isRinged());
//		System.out.println(myLinkedList2.getCyclelength());
//		Node last = myLinkedList2.findNode(4);
//		last.next=myLinkedList2.head;
//		System.out.println(last.data);
//		Node newhead = myLinkedList2.findReverNode(6);
//		myLinkedList2.add(newhead);
//		System.out.println(newhead.data);
//		System.out.println(myLinkedList2.isRinged());
//		System.out.println(myLinkedList2.getCyclelength());
	}
}
