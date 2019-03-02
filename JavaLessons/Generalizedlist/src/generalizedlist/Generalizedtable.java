package generalizedlist;

import java.util.Stack;

public class Generalizedtable {
	public static final int ATOM = 0;
	public static final int LIST = 1;
	
	public char StartSymb = '(';
	public char EndSymb = ')';
	public Node Genlist;
	
	public Generalizedtable() {
		Genlist=new Node(null,null,LIST,null);
	}
	
	//ʹ�ù����src����һ���µĹ����
	public Generalizedtable(Generalizedtable src) {
		if(src!=null) {
			Genlist=src.Genlist;
		}
	}
	
	public Generalizedtable(String genlist) {
		if(genlist==null) {
			throw new NullPointerException("genlist is null in construct Generalizedtable!...");
		}
		initlist(genlist);
	}
	
	//������ʾ���ţ�ʹ���ַ�����������ʱ��һ���ַ�������'(', '{', '[' ֮һ������'], ')', '}'֮һ���������Ҹ��������Ӧ
	public void initSymbolicCharacter(String ts) {
		StartSymb=ts.charAt(0);
		switch (StartSymb) {
			case '(':
				EndSymb=')';
				break;
			case '{':
				EndSymb='}';
				break;
			case '[':
				EndSymb=']';
				break;
			default:
				throw new IllegalArgumentException("IllegalArgumentException ---> initSymbolicCharacter");
		}
	}
	
	public void initlist(String genlist) {
		String ts=genlist.replaceAll("\\s", "");
		int len=ts.length();
		Stack<Character> symbStack = new Stack<Character>();
		Stack<Node> nodeStack = new Stack<Node>();
		initSymbolicCharacter(ts);
		Genlist=new Node(null,null,LIST,null);
		Node atomNode;
		Node listNode=Genlist;
		Node tempNode;
		for(int i=0;i<len;i++) {
			//StartSymb��ʾ������ '����ʼָʾ��' 
			if(ts.charAt(i)==StartSymb) {//��������(�� ʱ����һ�����㣬���÷���ѹջcharStack��
			//���ջ�е����ݳ���>1��������������ȼ���һ�㣬��ʱ���ý��ѹ��ջnodeStack����
			//node��ph���ָ���¹���Ľ�㡣
				tempNode=new Node(null,null,LIST,null);
//				listNode=listNode.pt;
				//��'����ʼָʾ��ѹջ'
				symbStack.push(ts.charAt(i));
				//�ж�symbStackջ�Ĵ�С
				if(symbStack.size()>1) {
					//����ǰ�ı���ѹջ
					nodeStack.push(listNode);
					//��ͷָ���µ�node 
					listNode.ph=tempNode;
					//��ǰ�����ǰ����һ��λ��
					listNode=listNode.ph;
				}else {
					listNode.pt=tempNode;
					listNode=listNode.pt;
				}
			}else if(ts.charAt(i)==EndSymb) {//����������')'ʱ����� symbStack�ĳ��� > 1 , ��
			//����ʱ��û�лص��������㣬�϶�����һ��nodeStack�еĽ����Ҫ��ջ����������֮��
			//Ӧ�� ��(�� ���ų�ջ
				if(symbStack.isEmpty()) {
					throw new IllegalArgumentException("IllegalArgumentException in construct Generalizedtable!...");
				}
				if(symbStack.size()>1) {
					listNode=nodeStack.pop();
				}
				symbStack.pop();
			}else if(ts.charAt(i)==','){//���������š�,�� ʱ����һ�����㣬�õ�ǰ���ı�βָ���µĽ��
				listNode.pt=new Node(null,null,LIST,null);
				listNode=listNode.pt;
			}else {//������ԭ�ӽ�����(��'a')ʱ���򴴽�һ��ԭ�ӽ�㣬�ñ�ͷָ��ý��
				atomNode=new Node(null,null,ATOM,ts.charAt(i));
				listNode.ph=atomNode;
			}
		}
		if(!symbStack.isEmpty()) {
			throw new IllegalArgumentException("IllegalArgumentException in construt Generalizedtable!...");
		}
	}
	
	public void print() {
		print(Genlist);
	}
	
	//һ��������ȴ�ӡ����ԭ�����е�����
	public void print(Node node) {
		if(node==null) {
			return;
		}
		if(node.tag==0) {
			System.out.print(node.data.toString()+" \t");
		}
		print(node.ph);
		print(node.pt);
	}
	
	public int depth() {
		if(Genlist==null) {
			throw new NullPointerException("Generalized List is null!.. ---> method depth");
		}
		return depth(Genlist);
	}
	
	//������ɱ�ͷ�ͱ�β��ɣ� ����������Ǳ�ͷ����β�е������ȡ�
	public int depth(Node node) {
		if(node==null||node.tag==ATOM) {
			return 0;
		}
		int depthheader=0;
		int depthtail=0;
		depthheader=1+depth(node.ph);
		depthtail=depth(node.pt);
		return depthheader > depthtail ? depthheader : depthtail;
	}
	
	//�ñ�ĳ��ȵ���ԭ�ӽ������ĸ������� header.pt != null �ĸ��� 
	public int length() {
		if(Genlist==null||Genlist.pt==null) {
			return -1;
		}
		int Len=0;
		Node node=Genlist;
		while(node.pt!=null) {
			node=node.pt;
			if(node.ph==null&&node.ph==null) {
				break;
			}
			Len++;
		}
		return Len;
	}
	
	public boolean isEmpty() {
		if(Genlist==null) {
			return true;
		}
		Node node=Genlist.pt;
		return node==null||node.ph==null;
	}
	
	//�����ĵ�һ���Ϊ��ͷ����ͷ������һ��ԭ����͹�������ǲ�����Σ������ǵ�һ����phָ�������
	public Generalizedtable getHeader() {
		if(isEmpty()) {
			return null;
		}
		Node node=Genlist.pt;
		Generalizedtable gl=new Generalizedtable();
		gl.Genlist.pt=node.ph;
		return gl;
	}
	
	//�����ı�β�ض���һ���������������ʲô�ӱ���ɣ����ǹ�����pt��ָ�������
	public Generalizedtable getTail() {
		if(isEmpty()) {
			return null;
		}
		Node node=Genlist.pt;
		Generalizedtable gl=new Generalizedtable();
		gl.Genlist.pt=node.pt;
		return gl;
	}
}
