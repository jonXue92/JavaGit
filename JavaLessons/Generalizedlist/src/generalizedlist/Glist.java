package generalizedlist;

//Ϊ��Ӧ��ֵ���ݣ�ֻ�ܴ������ÿ������޷����ݡ���ַ��������
class Temp{
	String string="";
	public Temp(String s) {
		string=s;
	}
}

// ��������������Ľ���������ȣ����ƣ����õ��ǽ��������Ϊ��ͷ���͡�β����ģʽ��
public class Glist {
	//�������
	public static int ATOM=0;//�ý��Ϊԭ�ӽ��
	public static int LIST=1;//�ý��Ϊ����
	
	public int tag;//�������ֽ��
	public Object atom;//ԭ�ӽ������ݣ�Ϊ����ʱ��ֵ����Ч��
	public Glist hp;//ָ���ͷ����һ�������ԭ�ӽ�㡣
	public Glist tp;//ָ���β���ض���һ������ ���� null��
	
	//�ú����ѱ�ͷ�ͱ�β�ֿ�
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
	//������������õݹ鷽ʽ�����������ǿձ��ԭ�ӡ��ݹ齨����ͷ�ͱ�β
	public static Glist createGlist(Glist L,String s) {
		System.out.println(s);
		Glist p = null;
		Glist q = null;
		if(s.equals("()")) {//����ǿձ�
			L=null;
		}else {
			L = new Glist();
			if (s.length()==1) {//������ԭ�ӹ����
				L.tag=ATOM;
				L.atom=s.charAt(0);
			}else {
				L.tag=LIST;
				p=L;
				String sub=s.substring(1,s.length()-1);
				do {//Сβ���ѳ�ͷ��ѭ������ͬһ��εĽ��
					Temp temp = new Temp(sub);
					String hsub=sever(temp);
					sub=temp.string;
					p.hp=createGlist(p.hp, hsub);
					q=p;//hsub��ͷ����ͷ
					if(!sub.isEmpty()) {//�����β
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
	
	//����������
	public static int GetDeepth(Glist L) {
		if(L==null) {
			return LIST;//�ձ�
		}
		if(L.tag==ATOM) {
			return ATOM;//ԭ��
		}
		int max=0;
		Glist p = L;
		for(;p!=null;p=p.tp) {//��ͬһ��Ĺ����Ԫ�ص�������
			int tem=GetDeepth(p.hp);
			if(tem>max) {
				max=tem;
			}
		}
		return max+1;
	}
	
	//���ƹ����
	public static Glist Copy(Glist M,Glist L) {//���ƹ������L���Ƶ�M		
		if(L==null) {
			M=null;//�ձ�
		}else {
			M=new Glist();
			M.tag=L.tag;
			if(M.tag==ATOM) {
				M.atom=L.atom;
			}else {
				M.hp=Copy(M.hp,L.hp);//����ͷ
				M.tp=Copy(M.tp,L.tp);//����β
			}
		}
		return M;
	}
}
