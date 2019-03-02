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
	//�Ѹ�������ĸ��Ʒ�Ϊ��������һ���Ǹ���ԭʼ�����ϵ�ÿ�����N����N'������next�����������ڶ���������random
	//ָ����S������S��λ���������п�����N��ǰ��Ҳ������N�ĺ��棬����Ҫ��λS��λ����Ҫ��ԭʼ�����ͷ��㿪ʼ�ҡ�
	//�����ԭʼ�����ͷ��㿪ʼ����next����s���ҵ����S����ô�ڸ��������Ͻ��N'��random����ΪS'���븴�������
	//ͷ���ľ���Ҳ������nextָ��s���������ְ취���ǾͿ���Ϊ���������ϵ�ÿ���������randomָ�롣����ÿһ������
	//n�������������ڶ�λÿ������random����Ҫ������ͷ��㿪ʼ����O(n)�������ҵ���������ַ�������ʱ�临��
	//����O(n^2)��
	
	//�����ʱ��Ϊ��Ҫ���ڶ�λ����random���档��һ����Ȼ�Ǹ���ԭʼ�����ϵ�ÿ�����N����N'��Ȼ����next������
	//����ͬʱ���ǰ�<N, N'>�������Ϣ�ŵ�һ����ϣ���С��ڶ����������ø��������ϵ�ÿ������random�������ԭʼ��
	//���н��N��randomָ����S����ô�ڸ��������У���Ӧ��N'Ӧ��ָ��S'���������˹�ϣ�����ǿ�����O(1)��ʱ���
	//��S�ҵ�S������������O(n)�Ŀռ任����O��n����ʱ�临�Ӷȡ�
	public RandomListNode clone0(RandomListNode pHead) {
		if(pHead==null) {
			return null;
		}
		HashMap<RandomListNode, RandomListNode> map=new HashMap<RandomListNode, RandomListNode>();
		RandomListNode pCloneHead = new RandomListNode(pHead.label);//���������ͷ���
		RandomListNode pNode = pHead;
		RandomListNode pCloneNode = pCloneHead;
		map.put(pNode, pCloneNode);
		//��һ����hashMap���棬ԭ������ӳ�临��������
		while (pNode.next!=null) {
			pCloneNode.next=new RandomListNode(pNode.next.label);
			pNode=pNode.next;
			pCloneNode=pCloneNode.next;
			map.put(pNode,pCloneNode);
		}
		//�ڶ������ҵ���Ӧ��random
		pNode=pHead;
		pCloneNode=pCloneHead;
		while(pCloneNode!=null) {
			pCloneNode.random=map.get(pNode.random);
			pNode=pNode.next;
			pCloneNode=pCloneNode.next;
		}
		return pCloneHead;
	}
	//����˼·����һ��:����ԭʼ�����ÿ�����N������Ӧ��N',����N'������N�ĺ��棻�ڶ��������ø��Ƴ����Ľ���random
	//ԭʼ�����ϵ�A��randomָ����C����ô���Ӧ���Ƴ�����A����A��nextָ��Ľ�㣬ͬ��C��Ҳ��C��nextָ��Ľ�㡣
	//��A' = A.next��A'.random = A.random.next�����������Ϳ��԰�ÿ������random������ϡ�������������
	//�����ֳ���������������λ�õĽ����m_next������������ԭʼ������ż��λ�õĽ����m_next�����������Ǹ���
	//����������
	public void cloneNodes(RandomListNode pHead) {
		RandomListNode pNode=pHead;
		while(pNode!=null) {
			//����pCloned��㼴A'���ʹ��ָ��ԭʼ������A������һ���B,����A'��random����Ϊnull
			RandomListNode pCloned = new RandomListNode(pNode.label);
			pCloned.next=pNode.next;
			pCloned.random=null;
			//��A���ָ��A�����
			pNode.next = pCloned;
			//ʹpNodeָ��A����һ���B���Դ�ѭ���޸�(��ʱ�м��ѽ���¡���A��������ԭʼ�б�)
			pNode = pCloned.next;
		}
	}
	//����ÿ������random(ע��randomΪ�ս�㲻���޸�)
	public void cloneRandom(RandomListNode pHead) {
		RandomListNode pNode=pHead;
		while(pNode!=null) {
			if(pNode.random!=null) {
				pNode.next.random=pNode.random.next;
			}
			pNode=pNode.next.next;
		}
	}
	//�������
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
		//����Ҳ��
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
