package chapter3;

public class LowerToUpper {

    public static void main(String[] args) {
        String str="abS12";
        char[] chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='a' && chars[i]<='z'){
                chars[i]=(char)(chars[i]-'a'+'A');
            }
        }
        String res=new String(chars);
        System.out.println(res);
    }
}
