package generalizedlist;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Glist L=null;
//		String s="(((a,b),(c,d)),(e,(f,g),h),z)";
//		//建表
//		L=Glist.createGlist(L, s);
//		//求表深度
//		int len=Glist.GetDeepth(L);
//		System.out.println(len);
//		//表复制
//		Glist M=null;
//		M=Glist.Copy(M, L);
		String p="((),a,b,(a,b,c),(a,(a,b),c))";
//		String p2="((()),2)";
//		String space="()";
//		String big = "{{a,b},{{a,g},{h},{a,n,f,{a,b,c}}},c}";
//      String middle = "[[p],[[d,f,[g]]],[h],[2]]";
        Generalizedtable gTab = new Generalizedtable(p);
        Generalizedtable header, tail;
        gTab.print();
        System.out.println();
        System.out.println("length: " + gTab.length());
        System.out.println("depth: " + gTab.depth());
        header = gTab.getHeader();
        if (header != null) {
        	System.out.println("header: ");
        	header.print();
        }
        System.out.println();
        tail = gTab.getTail();
        if (tail != null) {
        	System.out.println("tail: ");
        	tail.print();
        }
        System.out.println();
        gTab.print();
        System.out.println();
        Generalizedtable gTab3 = null;
        Generalizedtable gTab2 = new Generalizedtable(gTab3);
        gTab2.print();
        System.out.println();
        gTab2 = new Generalizedtable(gTab);
        gTab2.print();		
	}

}
