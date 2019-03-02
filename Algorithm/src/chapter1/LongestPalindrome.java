package chapter1;

public class LongestPalindrome {
    // A utility function to print a substring str[low..high]
    public static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }
    // This function prints the longest palindrome substring of str[].
    // It also returns the length of the longest palindrome
    public static int longestPalindrome(String s) {
        int n=s.length();// get length of input string
        boolean[][] pal=new boolean[n][n];//pal[i][j] 表示s[i...j]是否是回文串
        int maxLen = 0;
        int start = 0;
        for (int i=0;i<n;i++){  // i作为终点
            int j=i;    //j作为起点
            while (j>=0){
                if (s.charAt(j)==s.charAt(i)&&(i-j<2||pal[j+1][i-1])){
                    pal[j][i]=true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                    }
                }
                j--;
            }
        }
//        最长回文子串是元素得是连续的
//        写n-3和n-1是一样的。因为如果写n-1，前两次外循环中，i的值分别为n-1和n-2，那么内循环的j的初始值分别为n+1和n，
//        那么对于内循环的判断条件j < n来说，这两个j的初始值都是不符合的，因此对于这两次外循环，其中的内循环都不会被执行，
//        因此写n-3和n-1等价。当然写会n-3可能更加直观，容易理解。
//        为什么需要从最后开始遍历，能不能从0开始？
//        因为我们在计算dp[i][j]的时候，得知道所有的需要的信息,dp[i+1][j-1]，如果i是从0开始的，当我们计算dp[0][n-1]的时候，
//        还不知道dp[1][n-2]，因此会有错误，而如果从n-1开始，就没有问题
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i + 2; j < n; j++) {
//                //如果isPalindrome[i + 1][j - 1]是回文的，并且s.charAt(i) == s.charAt(j)，那么pal[i][j]也是回文的
//                pal[i][j] = pal[i + 1][j - 1] &&
//                        s.charAt(i) == s.charAt(j);
//
//                if (pal[i][j] && j - i + 1 > maxLen) {
//                    start = i;
//                    maxLen = j - i + 1;
//                }
//            }
//        }
//        最长回文序列是元素之间可以不连续
//        动态规划的思路是pal[i][j]表示i到j之间最长回文序列的最长长度
//        for (int j = i + 1; j < n; j++) {
//            if (s.charAt(i) == s.charAt(j)) {
//                //如果相等的情况下，就是pal[i+1][j-1]+2
//                pal[i][j] = pal[i + 1][j - 1] + 2;
//            } else {
//                //如果不相等，就是两者之中的最大值
//                pal[i][j] = Math.max(pal[i + 1][j], dp[i][j - 1]);
//            }
//        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(s, start, start + maxLen - 1);

        return maxLen;// return length of LPS
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalindrome(str));
    }
}