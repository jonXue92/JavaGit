package linkedlist;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode fihead = new RandomListNode(1);
		RandomListNode senode = new RandomListNode(2);
		RandomListNode thnode = new RandomListNode(3);
		RandomListNode fonode = new RandomListNode(4);
		RandomListNode finode = new RandomListNode(5);
		fihead.next=senode;
		senode.next=thnode;
		thnode.next=fonode;
		fonode.next=finode;
		fihead.random=thnode;
		senode.random=finode;
		thnode.random=null;
		fonode.random=senode;
		finode.random=null;
		RandomListNode resultNode=new RandomListNode().cloneall(fihead);
		RandomListNode temp=resultNode;
		while(temp!=null) {
			System.out.print(temp.label+" ");
			temp=temp.next;
		}
		System.out.println();
		temp=resultNode;
		while(temp!=null) {
			if(temp.random!=null) {
				System.out.print(temp.random.label+" ");
			}else {
				System.out.print("#	");
			}
			temp=temp.next;
		}
	}
}