package chapter1;

public class StrStr {
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (source.length() == 0) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (source.length() == 0) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        //mod could be any big integer just make sure mod * 33 wont exceed max value of int.
        int mod = Integer.MAX_VALUE / 33;
        int hash_target = 0;

        // 33 could be something else like 26 or whatever you want
        for (int i = 0; i < target.length(); i++) {
            hash_target = ((hash_target * 33 % mod + target.charAt(i) - 'a') % mod + mod) % mod;
        }
        int m33 = 1;
        for (int i = 0; i < target.length() - 1; i++) {
            m33 = m33 * 33 % mod;
        }
        int value = 0;
        for (int i = 0; i < source.length(); i++) {
            if (i >= target.length()) {
                value = (value - m33 * (source.charAt(i - target.length()) - 'a')) % mod;
            }
            value = (value * 33 + source.charAt(i) - 'a') % mod;
            if (value < 0) {
                value += mod;
            }

            if (i >= target.length() - 1 && value == hash_target) {
                // you have to double check by directly compare the string
                if (target.equals(source.substring(i - target.length() + 1, i + 1))) {
                    return i - target.length() + 1;
                }
            }
        }
        return -1;
    }
}
