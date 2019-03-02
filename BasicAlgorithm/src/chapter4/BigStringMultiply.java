package chapter4;

public class BigStringMultiply {
    public static String multiply(String num1, String num2) {
        // write your code here
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] num3 = new int[(len1+len2)];
        for (int i = len1 - 1; i >= 0; i--){
            for (int j = len2 - 1; j >= 0; j--){
                num3[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int k = (len1 + len2 - 1); k >= 1; k--){
            num3[k - 1] += num3[k] / 10;
            num3[k] = num3[k] % 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < (len1 + len2) && num3[i] == 0){
            i++;
        }
        while (i < (len1 + len2)){
            sb.append(num3[i++]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str1 = "10";
        String str2 = "17827182162716726172671";
//        String str2 = "912891271261762152615265166721812910291921";
        System.out.println(multiply(str1,str2));
    }
}
