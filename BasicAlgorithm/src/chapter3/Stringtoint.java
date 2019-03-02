package chapter3;

import java.sql.SQLClientInfoException;

public class Stringtoint {

    public static int stringtoint(String str){
        return 0;
    }
    public static void main(String[] args) {
        String str="123";
//        String str;
        System.out.println(Integer.valueOf(str));
        System.out.println(Integer.parseInt(str));
        int result = 0;
        if(str == null || str.isEmpty()){
            result = 0;
        }
        int start = 0;
        while(start < str.length() && str.charAt(start) == ' '){
            start++;
        }
        boolean isNegative = str.charAt(start) == '-';
        int sign = isNegative?-1:1;
        start += (str.charAt(start) == '+' || isNegative)?1:0;
        long res = 0;
        for(int i = start;i < str.length();i++){
            char ch = str.charAt(i);
            if(!Character.isDigit(ch)){
                break;
            }else{
                res = res*10+ch-'0';
            }
            if((sign*res)>Integer.MAX_VALUE){
                result=Integer.MAX_VALUE;
            }
            if((sign*res)<Integer.MIN_VALUE){
                result=Integer.MIN_VALUE;
            }
        }
        result=(int)(sign*res);
        System.out.println(result);
    }
}
