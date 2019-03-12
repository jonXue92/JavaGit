package bitoperation;

public class SingleNumber {
    // 1个数字出现一次，其余出现两次
    public int singleNumber12(int[] nums) {
        int result = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            result ^= nums[i];
        }
        return result;
    }
    // 1个数字出现一次，其余出现三次
    public int singleNumber13(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
    // 2个数字出现一次，其余出现三次
    public int[] singleNumber11(int[] nums) {
        // 用于记录，区分“两个”数组
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }
        // 取最后一位1
        // 先介绍一下原码，反码和补码
        // 原码，就是其二进制表示（注意，有一位符号位）
        // 反码，正数的反码就是原码，负数的反码是符号位不变，其余位取反
        // 补码，正数的补码就是原码，负数的补码是反码+1
        // 在机器中都是采用补码形式存
        // diff & (-diff) 就是取diff的最后一位1的位置
        diff &= -diff;
        int[] rets = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            //分属两个“不同”的数组
            if ((nums[i] & diff) == 0) {
                rets[0] ^= nums[i];
            } else {
                rets[1] ^= nums[i];
            }
        }
        return rets;
    }
}
