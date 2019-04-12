package chapter1;

public class RabinKarp {
    public int BASE = 1000003;
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        int power = 1;
        for (int i = 0; i < target.length(); i++) {
            power = (power * 31) % BASE;
        }
        int targetHash = 0;
        for (int i = 0; i < target.length(); i++) {
            targetHash = ((targetHash * 31) % BASE + target.charAt(i)) % BASE;
        }
        int sourceHash = 0;
        for (int i = 0; i < source.length(); i++) {
            // abc + d
            sourceHash = ((sourceHash * 31) % BASE + source.charAt(i)) % BASE;
            if (i < target.length() - 1) {
                continue;
            }
            // abcd - a
            if (i >= target.length()) {
                sourceHash = (sourceHash - (source.charAt(i - target.length()) * power) % BASE + BASE) % BASE;
            }
            // double check
            if (sourceHash == targetHash) {
                if (source.substring(i - target.length() + 1, i + 1).equals(target)) {
                    return i - target.length() + 1;
                }
            }
        }
        return -1;
    }

}
