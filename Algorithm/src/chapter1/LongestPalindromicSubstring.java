package chapter1;

// O(n^3)的枚举法解决最长回文子串（Longest Palindromic Substring）
public class LongestPalindromicSubstring {
    public int longestPalindrome(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
