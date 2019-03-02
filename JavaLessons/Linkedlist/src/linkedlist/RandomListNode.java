package linkedlist;

import java.util.HashMap;

public class RandomListNode {

	public int label;
	RandomListNode next=null;
	RandomListNode random=null;
	public RandomListNode() {
		
	}
	public RandomListNode(int label) {
		super();
		this.label=label;
	}
	//把复杂链表的复制分为两步：第一步是复制原始链表上的每个结点N创建N'，并用next连接起来；第二步是设置random
	//指向结点S，由于S的位置在链表中可能在N的前面也可能在N的后面，所以要定位S的位置需要从原始链表的头结点开始找。
	//如果从原始链表的头结点开始沿着next经过s步找到结点S，那么在复制链表上结点N'的random（记为S'）离复制链表的
	//头结点的距离也是沿着next指针s步。用这种办法我们就可以为复制链表上的每个结点设置random指针。对于每一个含有
	//n个结点的链表，由于定位每个结点的random都需要从链表头结点开始经过O(n)步才能找到，因此这种方法的总时间复杂
	//度是O(n^2)。
	
	//上面的时间为主要花在定位结点的random上面。第一步仍然是复制原始链表上的每个结点N创建N'，然后用next链接起
	//来。同时我们把<N, N'>的配对信息放到一个哈希表中。第二步还是设置复制链表上的每个结点的random。如果在原始链
	//表中结点N的random指向结点S，那么在复制链表中，对应的N'应该指向S'。由于有了哈希表，我们可以在O(1)的时间根
	//据S找到S’。这种是以O(n)的空间换来了O（n）的时间复杂度。
	public RandomListNode clone0(RandomListNode pHead) {
		if(pHead==null) {
			return null;
		}
		HashMap<RandomListNode, RandomListNode> map=new HashMap<RandomListNode, RandomListNode>();
		RandomListNode pCloneHead = new RandomListNode(pHead.label);//复制链表的头结点
		RandomListNode pNode = pHead;
		RandomListNode pCloneNode = pCloneHead;
		map.put(pNode, pCloneNode);
		//第一步，hashMap保存，原链表结点映射复制链表结点
		while (pNode.next!=null) {
			pCloneNode.next=new RandomListNode(pNode.next.label);
			pNode=pNode.next;
			pCloneNode=pCloneNode.next;
			map.put(pNode,pCloneNode);
		}
		//第二步，找到对应的random
		pNode=pHead;
		pCloneNode=pCloneHead;
		while(pCloneNode!=null) {
			pCloneNode.random=map.get(pNode.random);
			pNode=pNode.next;
			pCloneNode=pCloneNode.next;
		}
		return pCloneHead;
	}
	//最优思路。第一步:根据原始链表的每个结点N创建对应的N',不过N'连接在N的后面；第二步：设置复制出来的结点的random
	//原始链表上的A的random指向结点C，那么其对应复制出来的A’是A的next指向的结点，同样C’也是C的next指向的结点。
	//即A' = A.next，A'.random = A.random.next；故像这样就可以把每个结点的random设置完毕。第三步：将长
	//链表拆分成两个链表：把奇数位置的结点用m_next链接起来就是原始链表，把偶数位置的结点用m_next链接起来就是复制
	//出来的链表。
	public void cloneNodes(RandomListNode pHead) {
		RandomListNode pNode=pHead;
		while(pNode!=null) {
			//创建pCloned结点即A'结点使其指向原始链表中A结点的下一结点B,不过A'的random设置为null
			RandomListNode pCloned = new RandomListNode(pNode.label);
			pCloned.next=pNode.next;
			pCloned.random=null;
			//将A结点指向A’结点
			pNode.next = pCloned;
			//使pNode指向A的下一结点B并以此循环修改(此时中间已将克隆结点A‘插入了原始列表)
			pNode = pCloned.next;
		}
	}
	//设置每个结点的random(注：random为空结点不做修改)
	public void cloneRandom(RandomListNode pHead) {
		RandomListNode pNode=pHead;
		while(pNode!=null) {
			if(pNode.random!=null) {
				pNode.next.random=pNode.random.next;
			}
			pNode=pNode.next.next;
		}
	}
	//拆分链表
	public RandomListNode reconnectNodes(RandomListNode pHead) {
		RandomListNode pNode=pHead;
		RandomListNode pClonedHead=null;
		RandomListNode pCloned=null;
		if(pHead!=null) {
			pClonedHead=pHead.next;
			pCloned=pNode.next;
			pNode.next=pCloned.next;
			pNode=pNode.next;
		}
		while(pNode!=null) {
			pCloned.next=pNode.next;
			pCloned=pCloned.next;
			pNode.next=pCloned.next;
			pNode=pNode.next;
		}
		return pClonedHead;
	}
	public RandomListNode clone(RandomListNode pHead) {
		cloneNodes(pHead);
		cloneRandom(pHead);
		return reconnectNodes(pHead);
	}
	public RandomListNode cloneall(RandomListNode pHead) {
		if(pHead==null) {
			return null;
		}
		RandomListNode p = pHead;
		while (p!=null) {
			RandomListNode q=new RandomListNode(p.label);
			q.next=p.next;
			p.next=q;
			p=q.next;
		}
		p=pHead;
		while(p!=null) {
			if(p.random!=null) {
				p.next.random=p.random.next;
			}
			p=p.next.next;
		}
		p=pHead;
		RandomListNode qHead=pHead.next;
		RandomListNode q=qHead;
		while(p.next.next!=null) {
			p=p.next.next;
			q.next=p.next;
			q=q.next;
		}
		//下面也行
//		while(p!=null) {
//			RandomListNode q=p.next;
//			p.next=q.next;
//			if(q.next!=null) {
//				q.next=q.next.next;
//			}
//			p=p.next;
//		}
		return qHead;
	}
}
