package chapter4;

import java.util.ArrayList;
import java.util.List;

public class MyBigStringMultiply {
    public static String multiply(String num1, String num2) {
//      write your code here
        StringBuilder preres=new StringBuilder();
        int[] n1=strToIntList(num1);
        int[] n2=strToIntList(num2);
        int r=0,ciwei=0,jinwei=0;
        if(n1.length==1 && n1[0]==0 || n2.length==1 && n2[0]==0){
            return "0";
        }
        while(r<n1.length+n2.length-1){
            ciwei=jinwei;
            for(int i=0;i<=r;i++){
                if(i<n1.length && r-i<n2.length) {
                    ciwei += n1[i] * n2[r - i];
                }
            }
            jinwei=ciwei/10;
            preres.insert(0,ciwei%10);
            r++;
        }
        if(jinwei!=0){
            preres.insert(0,jinwei);
        }
        return new String(preres);
    }
    public static int[] strToIntList(String num){
        int[] res = new int[num.length()];
        for(int i=0;i<num.length();i++){
            res[i]=num.charAt(num.length()-1-i)-48;
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "10";
        String str2 = "17827182162716726172671";
//        String str2 = "912891271261762152615265166721812910291921";
        System.out.println(multiply(str1,str2));
    }
}

