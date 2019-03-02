package chapter3;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        // write your code here
        s=s.toLowerCase();
        if(s.length()==0 || s.length()==1){
            return true;
        }
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char ch1=s.charAt(i);
            if(!Character.isLetterOrDigit(ch1)){
                i++;
                continue;
            }
            char ch2=s.charAt(j);
            if(!Character.isLetterOrDigit(ch2)){
                j--;
                continue;
            }
            if(ch1!=ch2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="A man na MA";
        System.out.println(isPalindrome(s));
    }
}
