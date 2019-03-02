package generalizedlist;

//为了应对值传递，只能传递引用拷贝，无法传递“地址”的问题
class Temp{
	String string="";
	public Temp(String s) {
		string=s;
	}
}

// 广义表，包括广义表的建立，求深度，复制；采用的是将广义表划分为“头”和“尾”的模式。
public class Glist {
	//结点类型
	public static int ATOM=0;//该结点为原子结点
	public static int LIST=1;//该结点为表结点
	
	public int tag;//用于区分结点
	public Object atom;//原子结点的数据，为表结点时该值域无效。
	public Glist hp;//指向表头，是一个表结点或原子结点。
	public Glist tp;//指向表尾，必定是一个表结点 或者 null。
	
	//该函数把表头和表尾分开
	public static String sever(Temp t) {
		String str=t.string;
		int n=str.length();
		int i=0;
		int k=0;
		char ch;
		String hstr=null;
		do {
			ch=str.charAt(i);
			i++;
			if(ch=='(') {
				k++;
			}else if(ch==')') {
				k--;
			}
		}while(i<n && (ch!=',' || k!=0));
		if(i<n) {
			hstr=str.substring(0, i-1);
			str=str.substring(i);
		}else {
			hstr=str;
			str="";
		}
		t.string=str;
		return hstr;
	}
	//建立广义表，采用递归方式。结束条件是空表和原子。递归建立表头和表尾
	public static Glist createGlist(Glist L,String s) {
		System.out.println(s);
		Glist p = null;
		Glist q = null;
		if(s.equals("()")) {//如果是空表
			L=null;
		}else {
			L = new Glist();
			if (s.length()==1) {//创建单原子广义表
				L.tag=ATOM;
				L.atom=s.charAt(0);
			}else {
				L.tag=LIST;
				p=L;
				String sub=s.substring(1,s.length()-1);
				do {//小尾中脱出头，循环建立同一层次的结点
					Temp temp = new Temp(sub);
					String hsub=sever(temp);
					sub=temp.string;
					p.hp=createGlist(p.hp, hsub);
					q=p;//hsub是头建立头
					if(!sub.isEmpty()) {//如果有尾
						p=new Glist();
						p.tag=LIST;
						q.tp=p;
					}
				} while (!sub.isEmpty());
				q.tp=null;
			}
		}
		return L;
	}
	
	//求广义表的深度
	public static int GetDeepth(Glist L) {
		if(L==null) {
			return LIST;//空表
		}
		if(L.tag==ATOM) {
			return ATOM;//原子
		}
		int max=0;
		Glist p = L;
		for(;p!=null;p=p.tp) {//求同一层的广义表元素的最大深度
			int tem=GetDeepth(p.hp);
			if(tem>max) {
				max=tem;
			}
		}
		return max+1;
	}
	
	//复制广义表
	public static Glist Copy(Glist M,Glist L) {//复制广义表，把L复制到M		
		if(L==null) {
			M=null;//空表
		}else {
			M=new Glist();
			M.tag=L.tag;
			if(M.tag==ATOM) {
				M.atom=L.atom;
			}else {
				M.hp=Copy(M.hp,L.hp);//复制头
				M.tp=Copy(M.tp,L.tp);//复制尾
			}
		}
		return M;
	}
}
