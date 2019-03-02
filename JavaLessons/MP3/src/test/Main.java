package test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			char []m={'a','b','c'};
			char []n={'x','y','z'};
			int []num= {0,0,0};
	        int i=0;
			while(i!=3) {
				if(num[i]==3) {
					num[i]=0;
					i--;
					if(i==-1)
						break;
					num[i]++;
					continue;
				}
				if(m[i]=='a' && n[num[i]]=='x') {
					num[i]++;
					continue;
				}
				if(m[i]=='c' && (n[num[i]]=='x' || n[num[i]]=='z')) {
					num[i]++;
					continue;
				}
				for(int j=i-1; j>=0;j--) {
					if(num[i]==num[j]) {
						num[i]++;
						i--;
						break;
					}
				}
				i++;
			}
			for(int j=0; j<=2;j++)
				System.out.println(m[j]+" vs "+n[num[j]]);
	}
}
