package linkedlist;

public class Test0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwowayLinkedList myTwowayLinkedlist = new TwowayLinkedList();
		myTwowayLinkedlist.addTail(9);
		myTwowayLinkedlist.addHead(8);
		myTwowayLinkedlist.addHead(6);
		myTwowayLinkedlist.addTail(3);
		myTwowayLinkedlist.addTail(5);
		myTwowayLinkedlist.deleteHead();
		myTwowayLinkedlist.deleteTail();
		myTwowayLinkedlist.removebyvalue(8);
		myTwowayLinkedlist.updata(3, 4);
		System.out.println(myTwowayLinkedlist.getSize());
		myTwowayLinkedlist.display();
	}

}
