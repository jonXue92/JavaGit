package linkedlist;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyLinkedList myLinkedList = new MyLinkedList();
//		// ���������
//		myLinkedList.addNode(9);
//		myLinkedList.addNode(8);
//		myLinkedList.addNode(6);
//		myLinkedList.addNode(3);
//		myLinkedList.addNode(5);
//		// ��ӡ����
//		myLinkedList.printLink();
//		// �������������
//		System.out.println(myLinkedList.length());
//		// ��������
//		Node head = myLinkedList.linkSort();
//		System.out.println(head.data);
//		myLinkedList.printLink();
//		// ȥ���ظ����
//		myLinkedList.distinctLink();
//		myLinkedList.printLink();
//		// ����ת
//		myLinkedList.reserveLink();
//		myLinkedList.printLink();
//		// �������/��������
//		myLinkedList.reservePrt3(myLinkedList.head);
//		System.out.println();
//		// ����������м���
//		Node middleNode = myLinkedList.findMiddleNode();
//		System.out.println(middleNode.data);
//		// �ж������Ƿ��л�
//		boolean isRinged=myLinkedList.isRinged();
//		System.out.println(isRinged);
//		// ����������һ�����ָ��ͷ��㣬�����л���Ч��
//		Node lastNode = myLinkedList.getLastNode();
//		lastNode.next=myLinkedList.head;
//		isRinged=myLinkedList.isRinged();
//		System.out.println(isRinged);
//		// ɾ��ָ�����
//		Node nk=myLinkedList.findReverNode(3);
//		System.out.println(nk.data);
//		myLinkedList.deleteSpecialNode(nk);
//		myLinkedList.printLink();
//		// �����Ƿ��ཻ
//		// ������
//		MyLinkedList myLinkedList1 = new MyLinkedList();
//		myLinkedList1.addNode(1);
//		myLinkedList1.addNode(2);
//		myLinkedList1.printLink();
//		System.out.println(myLinkedList.isCross(myLinkedList.head, myLinkedList1.head));
//		// �ѵ�һ������ӵ�������㿪ʼ���ڵڶ�������ĺ��棬�����ཻ��Ч��
//		myLinkedList1.findNode(2).next=myLinkedList.findNode(3);
//		myLinkedList1.printLink();
//		System.out.println(myLinkedList.isCross(myLinkedList.head, myLinkedList1.head));
//		// ������������ཻ���������ཻ�Ľ���ֵ
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
