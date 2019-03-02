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
	
	//使用广义表src构造一个新的广义表
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
	
	//广义表表示符号：使用字符串构造广义表时第一个字符必须是'(', '{', '[' 之一，并以'], ')', '}'之一结束，并且各符号相对应
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
			//StartSymb表示广义表的 '表起始指示符' 
			if(ts.charAt(i)==StartSymb) {//当遇到‘(’ 时构造一个表结点，将该符号压栈charStack，
			//如果栈中的数据长度>1，表明广义表的深度加深一层，此时将该结点压入栈nodeStack，让
			//node的ph结点指向新构造的结点。
				tempNode=new Node(null,null,LIST,null);
//				listNode=listNode.pt;
				//将'表起始指示符压栈'
				symbStack.push(ts.charAt(i));
				//判断symbStack栈的大小
				if(symbStack.size()>1) {
					//将当前的表结点压栈
					nodeStack.push(listNode);
					//表头指向新的node 
					listNode.ph=tempNode;
					//当前结点向前滑动一个位置
					listNode=listNode.ph;
				}else {
					listNode.pt=tempNode;
					listNode=listNode.pt;
				}
			}else if(ts.charAt(i)==EndSymb) {//当遇到符号')'时，如果 symbStack的长度 > 1 , 表
			//明此时并没有回到表的最外层，肯定存在一个nodeStack中的结点需要出栈，接着让与之对
			//应的 ’(‘ 符号出栈
				if(symbStack.isEmpty()) {
					throw new IllegalArgumentException("IllegalArgumentException in construct Generalizedtable!...");
				}
				if(symbStack.size()>1) {
					listNode=nodeStack.pop();
				}
				symbStack.pop();
			}else if(ts.charAt(i)==','){//当遇到符号‘,’ 时构造一个表结点，让当前结点的表尾指向新的结点
				listNode.pt=new Node(null,null,LIST,null);
				listNode=listNode.pt;
			}else {//当遇到原子结点符号(如'a')时，则创建一个原子结点，让表头指向该结点
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
	
	//一个深度优先打印所有原子项中的数据
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
	
	//广义表由表头和表尾组成， 广义表的深度是表头、表尾中的最大深度。
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
	
	//该表的长度等于原子结点或表结点的个数，即 header.pt != null 的个数 
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
	
	//广义表的第一项称为表头，表头可能是一个原子项和广义表。但是不管如何，他都是第一个的ph指向的内容
	public Generalizedtable getHeader() {
		if(isEmpty()) {
			return null;
		}
		Node node=Genlist.pt;
		Generalizedtable gl=new Generalizedtable();
		gl.Genlist.pt=node.ph;
		return gl;
	}
	
	//广义表的表尾必定是一个广义表，但不管由什么子表组成，都是广义表的pt所指向的内容
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
